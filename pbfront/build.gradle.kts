var vaadinVersion = "24.0.5"

plugins {
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.0"
    id("java")
}

group = "org.zmalchunz.configurer.ui"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven("https://maven.vaadin.com/vaadin-prereleases")
    maven("https://maven.vaadin.com/vaadin-addons")
    maven( "https://plugins.gradle.org/m2/" )
}

dependencies {
    implementation("com.vaadin:vaadin-spring-boot-starter")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
//    testImplementation('org.springframework.boot:spring-boot-starter-test') {
//        excludeModule('org.junit.vintage:junit-vintage-engine')
//    }
}

dependencyManagement {
    imports {
        mavenBom("com.vaadin:vaadin-bom:$vaadinVersion")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}