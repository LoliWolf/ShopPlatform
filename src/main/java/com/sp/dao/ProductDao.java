package com.sp.dao;

import com.sp.entities.Product;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ProductDao {
    ArrayList<Product> getProducts(@Param("typeId") int typeId,@Param("num") int num);

    ArrayList<Product> getProductsByType(@Param("ptype") String ptype);

    Product getProduct(@Param("pid") int pid);

    Product getProductsByPid(@Param("pid") int pid);

    int IfProductExist(@Param("pid") int pid);
}
