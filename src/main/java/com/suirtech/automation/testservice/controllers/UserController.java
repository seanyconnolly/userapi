package com.suirtech.automation.testservice.controllers;

import com.suirtech.automation.testservice.model.User;
import com.suirtech.automation.testservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/userByUsername/{username}")
    public User user(@PathVariable String username) {
        return userRepository.findByUserName(username);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getTotalUsers")
    public long getTotalUsers() {
        return userRepository.count();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id) {
        if (userRepository.deleteById(id) == 1) {
            return String.format("User %d was deleted", id);
        } else {
            return String.format("Issue deleting user id %d", id);
        }
    }

}
