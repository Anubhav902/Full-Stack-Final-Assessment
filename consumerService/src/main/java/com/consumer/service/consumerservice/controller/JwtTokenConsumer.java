package com.consumer.service.consumerservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("/jwt-service/auth")
public interface JwtTokenConsumer {

    @GetMapping("/get-token/{id}")
    String createToken(@PathVariable String id);

    @GetMapping("/getUserId/{token}")
    String getUserId(@PathVariable("token") String token);
}
