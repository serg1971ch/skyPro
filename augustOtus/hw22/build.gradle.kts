plugins {
    id("java")
}

group = "ru.otus"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.testng:testng:7.1.0")
    implementation ("org.springframework.boot:spring-boot-starter")
    implementation 'org.projectlombok:lombok:1.18.28'
    implementation 'org.projectlombok:lombok:1.18.28'
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    compileOnly("org.projectlombok:lombok:1.18.24")
    implementation("org.hibernate:hibernate-core:6.3.1.Final")
    implementation("ch.qos.logback:logback-classic")
    implementation("org.ehcache:ehcache")
}

