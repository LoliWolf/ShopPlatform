package com.sp.service;

import java.util.HashMap;

public interface UserService {

    HashMap<String, String> login(String account, String password);

    HashMap<String,String> register(String account,String password,String username,String mobile);

    HashMap<String,String> info(HashMap<String,String> map);

    HashMap<String,String> update(HashMap<String,String> map,HashMap<String,String> headers);

    HashMap<String,String> password(HashMap<String,String> map,HashMap<String,String> headers);
}
