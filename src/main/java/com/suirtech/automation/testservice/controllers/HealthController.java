package com.suirtech.automation.testservice.controllers;

import com.suirtech.automation.testservice.model.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Health health() {
        return new Health();
    }

}
