package com.bct.msproducts2cl.security;

import com.bct.msproducts2cl.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


    public String generate(JwtUser jwtUser){

        Claims claims = Jwts.claims()
            .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getUserId()));
        claims.put("role", jwtUser.getRole());


                return  Jwts.builder()
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, "spring")
                        .compact();
    }
}
