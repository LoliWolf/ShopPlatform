package com.sp.service.impl;

import com.sp.dao.OrderDao;
import com.sp.dao.ProductDao;
import com.sp.service.OrderService;
import com.sp.utils.JWTUtils;
import com.sp.utils.MathUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Override
    public HashMap<String, String> apply(ArrayList<HashMap<String, String>> products, HashMap<String, String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))) {
            int uid = Integer.parseInt(verify.get("uid"));
            verify.remove("uid");
            String orderId = MathUtils.getRandomNumString(10);
            //防止订单号重复
            while(orderDao.ifOrderIdExist(orderId) != 0){
                orderId = MathUtils.getRandomNumString(10);
            }
            try{
                for (HashMap<String, String> product : products) {
                    if(productDao.IfProductExist(Integer.parseInt(product.get("pid")))==0||Integer.parseInt(product.get("pnum")) <= 0){
                        throw new EOFException();
                    }
                    orderDao.apply(orderId, uid, Integer.parseInt(product.get("pid")), Integer.parseInt(product.get("pnum")));
                }
                verify.put("orderID",orderId);
                verify.put("create","success");
                }
            catch (Exception e){
                //如果pid不存在或商品数量有误则回滚返回失败
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                System.out.println(e);
                verify.put("create","failed");
                verify.put("Exception","InvalidPid/Pnum");
            }
        }
        return verify;
    }
    @Override
    public HashMap<String,String> ok(HashMap<String,String> body,HashMap<String,String> headers){
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))) {
            verify.remove("uid");
            orderDao.ok(body.get("orderId"));
            verify.put("update","success");
        }
        return verify;
    }

}
