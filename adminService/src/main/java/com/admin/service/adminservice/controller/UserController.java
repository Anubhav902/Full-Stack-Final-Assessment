package com.admin.service.adminservice.controller;

import com.admin.service.adminservice.model.User;
import com.admin.service.adminservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String signUp(@RequestBody User user) {
        return userService.signupService(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map) {
        return userService.loginService(map.get("username").toString(), map.get("password").toString());
    }
}
