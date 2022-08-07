package com.sp.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface ShopCartService {

    HashMap<String,String> add(ArrayList<HashMap<String,String>> addlist,HashMap<String,String> headers);

    HashMap<String,String> delete(ArrayList<HashMap<String,String>> delList,HashMap<String,String> headers);

    HashMap<String, String> num(ArrayList<HashMap<String,String>> changeList,HashMap<String,String> headers);

    ArrayList<HashMap<String,String>> info(HashMap<String,String> headers);
}
