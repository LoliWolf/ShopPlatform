package com.sp.controller;

import com.sp.dao.ProductDao;
import com.sp.entities.Product;
import com.sp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/allproducts")
    private ArrayList<Product> allProducts(){
        return productService.allProducts();
    }

    @RequestMapping("/allsorts")
    private ArrayList<Product> allSorts(@RequestBody HashMap<String,String> map){
        return productService.allSorts(map);
    }

    @RequestMapping("/product")
    private Product product(@RequestBody HashMap<String,String> map){
        return productService.product(map);
    }
}
