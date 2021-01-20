package com.okgo.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootRedis02App {
    public static void main(String[] args) {
        SpringApplication.run(BootRedis02App.class, args);
    }
}
