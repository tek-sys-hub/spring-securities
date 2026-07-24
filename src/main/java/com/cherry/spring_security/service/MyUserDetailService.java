package com.cherry.spring_security.service;

import com.cherry.spring_security.model.MyUserDetails;
import com.cherry.spring_security.model.Users;
import com.cherry.spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("User doesnot exist");
            throw new UsernameNotFoundException("User not Found");
        }

        return new MyUserDetails(user);
    }
}
