package com.sp.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderService {
    HashMap<String,String> apply( ArrayList<HashMap<String,String>> products,  HashMap<String,String> headers);

    HashMap<String,String> ok(HashMap<String,String> body,HashMap<String,String> headers);
}
