package com.sp.entities;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.sp.controller.ShopCartController;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@NoAutoStart
@AllArgsConstructor
@Data
public class ShopCart {
    private int num;
    private int pid;
    private String type_name;
    private String image;
    private String pname;
    private String pdetails;
    private float price;

    public ShopCart(int num,Product product){
        this.num=num;
        pid=product.getPid();
        type_name= product.getType_name();
        image=product.getImage();
        pname=product.getPname();
        pdetails=product.getPdetails();
        price=product.getPrice();
    }

    public HashMap<String ,Object > toHashMap(){
        HashMap<String, Object> shopcart = new HashMap<>();
        shopcart.put("num",num);
        shopcart.put("pid",pid);
        shopcart.put("type_name",type_name);
        shopcart.put("image",image);
        shopcart.put("pname",pname);
        shopcart.put("pdetails",pdetails);
        shopcart.put("price",price);
        return shopcart;
    }

    public ShopCart(int num,int pid){
        this.num=num;
        this.pid=pid;
    }

}

