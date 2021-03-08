package com.example.cinema_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ServletComponentScan
@SpringBootApplication
@ImportResource({"classpath:application_context.xml"})
@EnableJpaRepositories(basePackages = "com.example.cinema_booking")
public class CinemaBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBookingApplication.class, args);
    }

}
