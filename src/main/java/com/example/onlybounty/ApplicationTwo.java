package com.example.onlybounty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.onlybounty")
public class ApplicationTwo {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTwo.class, args);
    }

}
