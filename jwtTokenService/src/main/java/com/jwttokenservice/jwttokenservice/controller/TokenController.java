package com.jwttokenservice.jwttokenservice.controller;

import com.jwttokenservice.jwttokenservice.service.TokenService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/get-token/{id}")
    public String createToken(@PathVariable String id) {
        return tokenService.createToken(id);
    }

    @GetMapping("/getUserId/{token}")
    public String getUserId(@PathVariable("token") String token) {
        return tokenService.getUserIdFromToken(token);
    }
}
