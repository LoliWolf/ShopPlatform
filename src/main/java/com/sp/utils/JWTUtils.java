package com.sp.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Calendar;
import java.util.HashMap;
@AllArgsConstructor
@Data
public class JWTUtils {
    public static String get(User user){//获取令牌
        HashMap<String,Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,20);
        return JWT.create()
                .withExpiresAt(instance.getTime())//指定令牌过期时间
                .withClaim("uid",user.getUid())
                .sign(Algorithm.HMAC256("%&$VYH%&"));
    }

    public static HashMap<String,String> verify(String token){//验证令牌
        HashMap<String,String> map=new HashMap<>();
        DecodedJWT ver;
        try {
            ver = JWT.require(Algorithm.HMAC256("%&$VYH%&")).build().verify(token);
        }
        catch(Exception e){
            map.put("login","failed");
            return map;
        }
        map.put("login","success");
        map.put("uid",ver.getClaim("uid").asInt().toString());
        return map;
    }

}
