package com.sp.service.impl;

import com.sp.dao.OrderDao;
import com.sp.dao.ProductDao;
import com.sp.dao.UserDao;
import com.sp.entities.Order;
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
import java.util.Set;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;
    @Override
    public HashMap<String, String> apply(ArrayList<HashMap<String, String>> products, HashMap<String, String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))) {
            int uid = Integer.parseInt(verify.get("uid"));
            verify.remove("uid");
            String address = userDao.get(uid).getAddress();
            String orderId = MathUtils.getRandomNumString(10);
            while(orderDao.ifOrderIdExist(orderId) != 0){
                orderId = MathUtils.getRandomNumString(10);
            }
            try{
                for (HashMap<String, String> product : products) {
                    if(productDao.IfProductExist(Integer.parseInt(product.get("pid")))==0||Integer.parseInt(product.get("pnum")) <= 0){
                        throw new EOFException();
                    }
                    orderDao.applyProduct(orderId,Integer.parseInt(product.get("pid")),Integer.parseInt(product.get("pnum")));
                }
                orderDao.applyOrder(orderId,uid,address);
                verify.put("orderID",orderId);
                verify.put("create","success");
                }
            catch (Exception e){
                //如果pid不存在或商品数量有误则回滚返回失败
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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

    @Override
    public ArrayList<HashMap<String,Object>> get(HashMap<String, String> body, HashMap<String, String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))) {
            String orderId = body.get("orderId");
            ArrayList<HashMap<String,Object>> products = orderDao.getProductByOrderId(orderId);
            HashMap<String, Object> details = orderDao.getOrderByOrderId(orderId);
            if(details == null){
                details = new HashMap<>();
                details.put("order","invalid");
            }
            return products;
        }
        else {
            HashMap<String, Object> log = new HashMap<>();
            ArrayList<HashMap<String, Object>> login = new ArrayList<>();
            log.put("login", "failed");
            login.add(log);
            return login;
        }
    }

    @Override
    public ArrayList<HashMap<String, Object>> check(HashMap<String, String> headers) {
        String token = headers.get("token");
        HashMap<String, String> verify = JWTUtils.verify(token);
        if("success".equals(verify.get("login"))) {
            ArrayList<String> orderIdList = orderDao.getOrderIdByUid(Integer.parseInt(verify.get("uid")));
            ArrayList<HashMap<String, Object>> orderList = new ArrayList<>();
            for(String orderId:orderIdList) {
                ArrayList<HashMap<String, Object>> products = orderDao.getProductByOrderId(orderId);
                HashMap<String, Object> details = orderDao.getOrderByOrderId(orderId);
                Order order = new Order(orderId, (Boolean) details.get("status"), products, String.valueOf(details.get("address")));
                HashMap<String, Object> map = new HashMap<>();
                map.put("order",order);
                orderList.add(map);
            }
            return orderList;
        }
        else {
            HashMap<String, Object> log = new HashMap<>();
            ArrayList<HashMap<String, Object>> login = new ArrayList<>();
            log.put("login", "failed");
            login.add(log);
            return login;
        }
    }
}
