package com.cherry.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Set the mapping for homepage
    @GetMapping("/")
    public String greet (){
        return "Welcome to cherry hub";
    }
}
