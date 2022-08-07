package com.sp.controller;

import com.sp.entities.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService user;

    @RequestMapping("/login")
    private HashMap<String, String> login(@RequestBody User user1){
        return user.login(user1.getAccount(), user1.getPassword());
    }

    @RequestMapping("/register")
    private HashMap<String,String> register(@RequestBody User user1){
        return user.register(user1.getAccount(), user1.getPassword(), user1.getUsername(), user1.getMobile());
    }

    @RequestMapping("/info")
    private HashMap<String,String> info(@RequestHeader HashMap<String,String> map){
        return user.info(map);
    }

    @RequestMapping("/update")
    private HashMap<String,String> update(@RequestBody HashMap<String,String> map,@RequestHeader HashMap<String,String> headers){
        map.put("token",headers.get("token"));
        return user.update(map);
    }
}
