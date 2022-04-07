package com.company.util;

import com.company.dto.JwtDTO;
import io.jsonwebtoken.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {
    private final static String secretKey = "kalitso'z";

    public static String createJwt(Integer id, String username) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(String.valueOf(id));
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secretKey);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)));
        jwtBuilder.claim("userName", username);
        jwtBuilder.setIssuer("apelsin");
        String jwt = jwtBuilder.compact();
        return jwt;
    }

    public static JwtDTO decodeJwt(String jwt) {
        try {

            JwtParser jwtParser = Jwts.parser();

            jwtParser.setSigningKey(secretKey);
            Jws jws = jwtParser.parseClaimsJws(jwt);

            Claims claims = (Claims) jws.getBody();
            Integer id = Integer.valueOf(claims.getSubject());
            String userName = (String) claims.get("userName");
            return new JwtDTO(id, userName);
        } catch (JwtException e) {
            e.printStackTrace();
        }
        return null;
    }
}