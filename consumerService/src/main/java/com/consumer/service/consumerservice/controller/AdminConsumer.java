package com.consumer.service.consumerservice.controller;

import com.consumer.service.consumerservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("/admin-service/user")
public interface AdminConsumer {

    @PostMapping("/registration")
    String signUp(@RequestBody User user);

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map);
}
