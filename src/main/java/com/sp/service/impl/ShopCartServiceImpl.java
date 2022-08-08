package com.sp.service.impl;

import com.sp.dao.ProductDao;
import com.sp.dao.ShopCartDao;
import com.sp.entities.Product;
import com.sp.entities.ShopCart;
import com.sp.service.ShopCartService;

import com.sp.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;

@Transactional
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartDao shopCartDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public HashMap<String, String> add(ArrayList<HashMap<String,String>> addlist,HashMap<String,String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if ("success".equals(verify.get("login"))) {
            int uid = Integer.parseInt(verify.get("uid"));
            verify.remove("uid");
            try {
                for (HashMap<String, String> map : addlist) {
                    int pid = Integer.parseInt(map.get("pid"));
                    int num = Integer.parseInt(map.get("num"));
                    int pnum = shopCartDao.getCount(uid, pid);
                    if (pnum == 0) {
                        shopCartDao.add(uid, pid, num);
                    } else {
                        shopCartDao.update(uid, pid, num);
                    }
                    if(shopCartDao.getNum(uid,pid)<0||productDao.IfProductExist(pid) == 0){
                        throw new EOFException();
                    }
                    else if(shopCartDao.getNum(uid,pid)==0){
                        shopCartDao.delete(uid,pid);
                    }
                }
                verify.put("update","success");

            }catch(Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                verify.put("update","failed");
            }
        }
        return verify;
    }

    @Override
    public HashMap<String, String> delete(ArrayList<HashMap<String, String>> delList, HashMap<String, String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))){
            int uid = Integer.parseInt(verify.get("uid"));
            verify.remove("uid");
            for (HashMap<String,String> del:delList){
                int pid = Integer.parseInt(del.get("pid"));
                if(shopCartDao.getCount(uid,pid)==0||productDao.IfProductExist(pid) == 0){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    verify.remove("update");
                    verify.put("update","failed");
                    break;
                }
                else{
                    shopCartDao.delete(uid,pid);
                    verify.put("update","success");
                }
            }
        }

        return verify;
    }

    @Override
    public HashMap<String, String> num(ArrayList<HashMap<String,String>> changeList,HashMap<String,String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))){
            int uid = Integer.parseInt(verify.get("uid"));
            verify.remove("uid");
            for (HashMap<String,String> change:changeList){
                int pid = Integer.parseInt(change.get("pid"));
                int num = Integer.parseInt(change.get("num"));
                if(shopCartDao.getCount(uid,pid)==0||num<0||productDao.IfProductExist(pid) == 0){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    verify.remove("update");
                    verify.put("update","failed");
                    break;
                }
                else{
                    shopCartDao.change(uid,pid,num);
                    if(shopCartDao.getNum(uid,pid)==0){
                        shopCartDao.delete(uid,pid);
                    }
                    verify.put("update","success");
                }
            }
        }

        return verify;
    }

    @Override
    public ArrayList<HashMap<String, Object>> info(HashMap<String, String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        if("success".equals(verify.get("login"))){
            int uid = Integer.parseInt(verify.get("uid"));
            verify.remove("uid");
            ArrayList<ShopCart> products = shopCartDao.getUserCart(uid);
            for(ShopCart s:products){
                Product product = productDao.getProductsByPid(s.getPid());
                arrayList.add((new ShopCart(s.getNum(),product)).toHashMap());
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("login",verify.get("login"));
        arrayList.add(map);
        return arrayList;
    }
}
