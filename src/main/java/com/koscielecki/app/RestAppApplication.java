package com.koscielecki.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestAppApplication.class, args);
    }

}
