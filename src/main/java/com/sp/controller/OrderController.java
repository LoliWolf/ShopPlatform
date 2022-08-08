package com.sp.controller;


import com.sp.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/apply")
    private HashMap<String,String> apply(@RequestBody ArrayList<HashMap<String,String>> products, @RequestHeader HashMap<String,String> headers){
        return orderService.apply(products,headers);
    }

    @RequestMapping("/ok")
    private HashMap<String,String> ok(@RequestBody HashMap<String,String> body,@RequestHeader HashMap<String,String> headers){
        return orderService.ok(body,headers);
    }


}
