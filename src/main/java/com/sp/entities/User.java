package com.sp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int uid;
    private String account;
    private String password;
    private String username;
    private String sex;
    private String mobile;
    private String address;

    public HashMap<String,String> toHashMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("uid",String.valueOf(uid));
        map.put("account",account);
        map.put("password",password);
        map.put("username",username);
        map.put("sex",sex);
        map.put("mobile",mobile);
        map.put("address",address);
        return map;
    }
}
