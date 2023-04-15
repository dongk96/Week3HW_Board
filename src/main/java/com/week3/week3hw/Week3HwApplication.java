package com.week3.week3hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week3HwApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week3HwApplication.class, args);
    }

}
