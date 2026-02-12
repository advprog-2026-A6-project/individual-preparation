plugins {
	java
	id ("org.springframework.boot") version "4.0.2"
	id ("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "Individual preparation for the Advanced Programming course at the Faculty of Computer Science Universitas Indonesia"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

val seleniumJavaVersion = "4.14.1"
val seleniumJupiterVersion = "5.0.1"
val webdrivermanagerVersion = "6.1.0"
val junitJupiterVersion = "5.9.1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("org.seleniumhq.selenium:selenium-java:${seleniumJavaVersion}")
	testImplementation("io.github.bonigarcia:webdrivermanager:${webdrivermanagerVersion}")
	testImplementation("io.github.bonigarcia:selenium-jupiter:${seleniumJupiterVersion}")
	testImplementation("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")
}

tasks.register<Test>("unitTest") {
	description = "Runs unit tests."
	group = "verification"

	filter {
		excludeTestsMatching("*FunctionalTest")
	}
}

tasks.register<Test>("functionalTest") {
	description = "Runs functional tests."
	group = "verification"

	filter {
		includeTestsMatching("*FunctionalTest")
	}
}

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
}
