package com.simplework.simplework.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    private static long expire = 604800;

    private static String secret = "qwertyuiopasdfghjklzxcvbnm";

    public static String generateToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder().setHeaderParam("type","JWT").setSubject(username).setIssuedAt(now).setExpiration(expiration).signWith(SignatureAlgorithm.ES512,secret).compact();
    }

    public static Claims getClaimsByToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
