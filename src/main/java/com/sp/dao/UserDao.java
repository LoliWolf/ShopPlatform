package com.sp.dao;

import com.sp.entities.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    User login(@Param("account") String account,@Param("password") String password);

    int  check(@Param("account") String account);

    void register(@Param("account") String account,@Param("password") String password,@Param("username") String username,@Param("mobile") String mobile);

    User get(@Param("uid") int uid);

    void update(@Param("uid") int uid,@Param("mobile") String mobile,@Param("username") String username,@Param("address") String address,@Param("sex") String sex);

    String getPassword(@Param("uid") int uid);

    void updatePassword(@Param("uid") int uid,@Param("password") String password);
}
