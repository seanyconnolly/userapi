package com.suirtech.automation.testservice.controllers;

import com.suirtech.automation.testservice.model.User;
import com.suirtech.automation.testservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/auth/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password) {
        if (userRepository.findByUserName(username).getPassword().equals(password)){
          return "Authenticated";
        } else {
            return "Sorry details incorrect";
        }
    }



}
