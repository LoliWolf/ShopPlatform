package com.sp.dao;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderDao {

    void apply(@Param("order_id") String orderID,@Param("uid") int uid,@Param("pid") int pid,@Param("pnum") int pnum);

    int ifOrderIdExist(@Param("orderId") String orderId);

    void ok(@Param("orderId") String orderId);

}
