plugins {
    id("java")
}

group = "org.zmalchunz.configurer"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven("https://maven.vaadin.com/vaadin-addons")
}


tasks.withType<Test> {
    useJUnitPlatform()
}