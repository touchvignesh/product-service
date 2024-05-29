plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.openapi.generator") version "7.5.0"
}

group = "com.excoder"
version = "1.0-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.5")
	implementation("org.postgresql:postgresql")
	implementation("org.springframework.kafka:spring-kafka:3.1.4")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

openApiGenerate {
	generatorName.set("java")
	inputSpec.set("$rootDir/src/main/resources/account_api_description.yaml")
	outputDir.set("${layout.buildDirectory}/generated/api")
	// Your other specification
}

openApiValidate {
	inputSpec.set("$rootDir/src/main/resources/account_api_description.yaml")
	recommend.set(true)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootJar {
	archiveFileName.set("product-service-1.0-SNAPSHOT.jar")
}
tasks.named<Jar>("jar") {
	enabled = false
}