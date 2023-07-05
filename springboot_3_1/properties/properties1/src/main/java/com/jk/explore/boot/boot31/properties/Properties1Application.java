package com.jk.explore.boot.boot31.properties;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class Properties1Application {
    public static void main(String [] args) {
        SpringApplication.run(Properties1Application.class, args);
    }
}
