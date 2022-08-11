package com.sp.controller;


import com.sp.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

@RestController
@RequestMapping("/shopcart")
@CrossOrigin
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping("/add")
    private HashMap<String,String> add(@RequestBody ArrayList<HashMap<String,String>> addlist,@RequestHeader HashMap<String,String> headers){
        return shopCartService.add(addlist,headers);
    }
    @RequestMapping("/delete")
    private HashMap<String,String> delete(@RequestBody ArrayList<HashMap<String,String>> dellist,@RequestHeader HashMap<String,String> headers){
        return shopCartService.delete(dellist,headers);
    }
    @RequestMapping("/num")
    private HashMap<String,String> num(@RequestBody ArrayList<HashMap<String,String>> changeList,@RequestHeader HashMap<String,String> headers){
        return shopCartService.num(changeList,headers);
    }
    @RequestMapping("/info")
    private ArrayList<HashMap<String,Object>> info(@RequestHeader HashMap<String,String> headers){
        return shopCartService.info(headers);
    }
    @RequestMapping("/clear")
    private HashMap<String,String> clear(@RequestHeader HashMap<String,String> headers){
        return shopCartService.clear(headers);
    }

}
