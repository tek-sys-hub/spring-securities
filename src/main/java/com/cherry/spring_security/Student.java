package com.cherry.spring_security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int roll;
    private String name;
    private String email;
    private Long phone;
}
