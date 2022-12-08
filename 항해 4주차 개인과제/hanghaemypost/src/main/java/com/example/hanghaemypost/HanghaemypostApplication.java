package com.example.hanghaemypost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaemypostApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanghaemypostApplication.class, args);
    }

}
