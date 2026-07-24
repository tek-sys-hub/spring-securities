package com.cherry.spring_security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Set the mapping for homepage
    @GetMapping("/")
    public String greet (HttpServletRequest request){
        return "Welcome to cherry hub" + request.getSession().getId();
    }
}
