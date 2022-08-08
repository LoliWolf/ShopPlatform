package com.sp.dao;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderDao {

    void applyOrder(@Param("order_id") String orderID,@Param("uid") int uid,@Param("address") String address);

    void applyProduct(@Param("order_id") String orderID,@Param("pid") int pid,@Param("pnum") int pnum);

    int ifOrderIdExist(@Param("orderId") String orderId);

    void ok(@Param("orderId") String orderId);

    ArrayList<HashMap<String,Object>> getProductByOrderId(@Param("orderId") String orderId);

    HashMap<String,Object> getOrderByOrderId(@Param("orderId") String orderId);

    ArrayList<String> getOrderIdByUid(@Param("uid") int uid);

}
