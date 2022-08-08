package com.sp.service.impl;

import com.sp.dao.ProductDao;
import com.sp.entities.Product;
import com.sp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public ArrayList<Product> allProducts() {//返回1手机 2家电 3日用百货 各10个
        ArrayList<Product> products = new ArrayList<>();
        products.addAll(productDao.getProducts(1,10));
        products.addAll(productDao.getProducts(2,10));
        products.addAll(productDao.getProducts(3,10));
        return products;
    }

    @Override
    public ArrayList<Product> allSorts(HashMap<String, String> map) {
        return productDao.getProductsByType(map.get("ptype"));
    }

    @Override
    public HashMap<String,Object> product(HashMap<String, String> map) {
        if(productDao.IfProductExist(Integer.parseInt(map.get("pid"))) == 0){
            HashMap<String, Object> ret = new HashMap<>();
            ret.put("Exception","invalidPid");
            return ret;
        }
        return productDao.getProduct(Integer.parseInt(map.get("pid"))).toHashMap();
    }
}
