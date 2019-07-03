package com.zhangyang.utils;

import com.zhangyang.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: ZhangYang
 * @Date: 2019/2/13 21:52
 */
public class JwtUtils {
    public static final String SUBJECT="zhangyang";
    public static final long EXPIRE=1000*60*60*24*7;//设置过期时间为一周
    public static final String APPSECRET="zy666";//秘钥


    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){
        if(user==null||user.getName()==null||user.getAccount()==null){
            return null;
        }
        String token=Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .claim("img",user.getAccount())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try {
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
