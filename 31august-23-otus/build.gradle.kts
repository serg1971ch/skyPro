plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "ru.otus"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
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
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	implementation ("org.assertj:assertj-core")
//	implementation ("javax.xml.bind:jaxb-api")
	implementation("javax.xml.bind:jaxb-api:2.3.1")
	implementation ("ch.qos.logback:logback-classic")
//	testImplementation("org.assertj:assertj-core:3.22.0")
	implementation("org.flywaydb:flyway-core")
	implementation("org.springframework.session:spring-session-core")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.assertj:assertj-core:3.24.2")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
