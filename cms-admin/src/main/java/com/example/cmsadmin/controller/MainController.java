package com.example.cmsadmin.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@SecurityRequirement(name = "Bearer Authentication")
public class MainController {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
