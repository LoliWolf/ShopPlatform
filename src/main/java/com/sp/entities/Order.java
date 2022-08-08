package com.sp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String order_id;
    private boolean status;
    private ArrayList<HashMap<String,Object>> products;
    private String address;
}
