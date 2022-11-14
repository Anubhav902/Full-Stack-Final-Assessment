package com.jwttokenservice.jwttokenservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {
    public static final String Token_Secret = "random_string_1234";

    public String createToken(String userId) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(Token_Secret);
            String token = JWT.create().
                               withClaim("userId",userId).
                               withClaim("createdAt", new Date()).
                               sign(algorithm);

            return token;
        }
        catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
        catch(JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public String getUserIdFromToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(Token_Secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            return decodedJWT.getClaim("userId").asString();
        }
        catch(UnsupportedEncodingException exception){
            exception.printStackTrace();
        }
        catch(JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public boolean isTokenValid(String token) {
        String userId = this.getUserIdFromToken(token);
        return userId != null;
    }
}

