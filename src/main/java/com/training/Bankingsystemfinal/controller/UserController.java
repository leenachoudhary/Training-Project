package com.training.Bankingsystemfinal.controller;

import com.training.Bankingsystemfinal.model.User;
import com.training.Bankingsystemfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/home")
    public String hello(){
        return "home";
    }
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}


