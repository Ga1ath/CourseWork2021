package com.example.cinema_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;


@ServletComponentScan
@SpringBootApplication
@ImportResource({"classpath:application_context.xml"})
public class CinemaBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBookingApplication.class, args);
    }

}
