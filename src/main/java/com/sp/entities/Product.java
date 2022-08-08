package com.sp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.StringReader;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int pid;
    private String type_name;
    private String image;
    private String pname;
    private String pdetails;
    private float price;


    public HashMap<String,Object> toHashMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("pid",pid);
        map.put("type_name",type_name);
        map.put("image",image);
        map.put("pname",pname);
        map.put("pdetails",pdetails);
        map.put("price",price);
        return map;
    }
}
