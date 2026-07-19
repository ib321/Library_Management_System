package com.ib.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Maven Based Web Application with
 * 1.Spring Boot
 * 2.Angular
 * 3.Auth with JWT
 */
@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}