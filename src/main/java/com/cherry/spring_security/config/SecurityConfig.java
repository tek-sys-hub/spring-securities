package com.cherry.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // This says this is a configuration
@EnableWebSecurity // This dont go with the default flow go with what i describe here
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    // Remove security that cames by default
    public SecurityFilterChain securityFilterChain (HttpSecurity https) {

        // Disable csrf
        return https.csrf(customizer -> customizer.disable())
        // Authorize the new user
                .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
        // Use the default value to login now
                //.formLogin(Customizer.withDefaults())
        // For clients like postman
                .httpBasic(Customizer.withDefaults())
        // Create A New Session Id In Every Request
                .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    // Changing the default auth provider to our which can connect to database too

    @Bean
    public AuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }


    // This return hard coded values for the login auth

//    @Bean
//    public UserDetailsService userDetailsService () {
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("Kiran")
//                .password("k@123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager();
//    }

}
