package com.sp.service;

import com.sp.dao.ProductDao;
import com.sp.entities.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductService {

    ArrayList<Product> allProducts();

    ArrayList<Product> allSorts(HashMap<String,String> map);

    Product product(HashMap<String,String> map);
}
