package org.zmalchunz.configurer.jbback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class BackApp {
    public static void main(String[] args) {
        SpringApplication.run(BackApp.class, args);
    }
}
