package com.okgo.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.okgo.mail")

public class SpringbootEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEmailApplication.class, args);
    }

}
