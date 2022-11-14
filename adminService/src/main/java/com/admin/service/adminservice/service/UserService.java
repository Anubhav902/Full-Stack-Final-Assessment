package com.admin.service.adminservice.service;

import com.admin.service.adminservice.model.User;
import com.admin.service.adminservice.repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String signupService(User user) {
        User savedUser = userRepository.save(user);
        return "User Saved : \n" + savedUser + "\n";
    }

    public String loginService(String username, String password) {
        List<User> users = userRepository.loginUser(username);
        if(users.isEmpty()) {
            return "User Not Found. Authentication Failed!";
        }
        else if(!users.get(0).getPassword().equals(password)) {
            return "Incorrect Password!";
        }
        return "Successfully Login!";
    }
}
