package org.zmalchunz.configurer.jbback.mongocontainer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

@Configuration
@EnableMongoRepositories("org.zmalchunz.configurer.jbback.*.repo")
@ComponentScan("org.zmalchunz.configurer.jbback.mongo.utility")
public class MongoContainerConfig {

    private static final String IMAGE_VERSION = "mongo:latest";
    private static final Integer MONGO_PORT = 27017;

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer(IMAGE_VERSION).withExposedPorts(MONGO_PORT);

    static {
        mongoDBContainer.start();
        var mappedPort = mongoDBContainer.getMappedPort(MONGO_PORT);
        System.setProperty("mongodb.container.port", String.valueOf(mappedPort));
    }
}
