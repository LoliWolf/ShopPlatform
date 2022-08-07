package com.sp.service.impl;

import com.sp.utils.JWTUtils;
import com.sp.dao.UserDao;
import com.sp.entities.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Iterator;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public HashMap<String, String> login(String account, String password) {
        User user = userDao.login(account, password);
        HashMap<String, String> map = new HashMap<>();
        if (user==null){
            map.put("login","failed");
        }
        else{

            String token = JWTUtils.get(user);
            map.put("token",token);
            map.put("login","success");
        }
        return map;
    }
    @Override
    public HashMap<String,String> info(@RequestBody HashMap<String,String> map){
        HashMap<String, String> ret = JWTUtils.verify(map.get("token"));
        if("success".equals(ret.get("login"))){
            HashMap<String, String> userMap = userDao.get(Integer.parseInt(ret.get("uid"))).toHashMap();
            for (String s : userMap.keySet()) {
                ret.put(s, userMap.get(s));
            }
            ret.remove("password");
            return ret;
        }
        return ret;
    }

    @Override
    public HashMap<String, String> update(HashMap<String, String> map) {
        HashMap<String, String> verify = JWTUtils.verify(map.get("token"));
        if("success".equals(verify.get("login"))){
            userDao.update(Integer.parseInt(verify.get("uid")),map.get("mobile"),map.get("username"),map.get("address"),map.get("sex"));
            verify.put("update","success");
            verify.remove("uid");
        }
        return verify;

    }

    @Override
    public HashMap<String,String> register(String account, String password, String username, String mobile) {
        HashMap<String, String> map = new HashMap<>();
        if(userDao.check(account)!=0) {
            map.put("register","failed");
        } else {
            userDao.register(account,password,username,mobile);
            map.put("register","success");
        }
        return map;
    }
}
