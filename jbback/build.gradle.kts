plugins {
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.0"
    id("java")
}

group = "org.zmalchunz.configurer"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

// Versions
val wiremock_version = "2.35.0"
val lombok_version = "1.18.22"
val testcontainers_version = "1.18.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("com.github.tomakehurst:wiremock-jre8-standalone:${wiremock_version}")
    implementation("org.projectlombok:lombok:${lombok_version}")
    annotationProcessor("org.projectlombok:lombok:${lombok_version}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:testcontainers:${testcontainers_version}")
    testImplementation("org.testcontainers:junit-jupiter:${testcontainers_version}")
    testImplementation("org.testcontainers:mongodb:${testcontainers_version}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}