package com.example.cinema_booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@ComponentScan
public class ContextConfiguration {

    @Bean
    @Scope("singleton")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
