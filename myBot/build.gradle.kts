plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "ru.skyPro"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.liquibase:liquibase-core:4.26.0")
	implementation("com.github.pengrad:java-telegram-bot-api:4.9.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito:mockito-core:5.12.0")
	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
