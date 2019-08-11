package com.packagename.myapp.spring;

import com.packagename.myapp.spring.HibernateFiles.HibernateConnect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        HibernateConnect.setUp();
        SpringApplication.run(Application.class, args);
    }

}
