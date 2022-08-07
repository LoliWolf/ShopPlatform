package com.sp.dao;

import com.sp.entities.ShopCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

public interface ShopCartDao {

    int getCount(@Param("uid") int uid,@Param("pid") int pid);

    int getNum(@Param("uid") int uid,@Param("pid") int pid);

    void add(@Param("uid") int uid,@Param("pid") int pid,@Param("num") int num);

    void update(@Param("uid") int uid,@Param("pid") int pid,@Param("num") int num);

    void delete(@Param("uid") int uid,@Param("pid") int pid);

    void change(@Param("uid") int uid,@Param("pid") int pid,@Param("num") int num);

    ArrayList<ShopCart> getUserCart(@Param("uid") int uid);

}
