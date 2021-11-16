import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
}

group = "me.luvram"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator") // actuator 를 통해 micrometer를 사용한다.
    implementation("org.springframework.boot:spring-boot-starter-aop") // micrometer timer를 사용하기 위해서 필요하다.

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("org.redisson:redisson:3.15.2")

    implementation("org.springframework.kafka:spring-kafka")
    // implementation("io.projectreactor.kafka:reactor-kafka:1.1.0.RELEASE")

    // micrometer
    implementation("io.micrometer:micrometer-core:1.7.0")
    implementation("io.micrometer:micrometer-registry-prometheus:1.7.0")
    implementation("io.prometheus:simpleclient_spring_boot:0.10.0")

    implementation("io.projectreactor.tools:blockhound:1.0.6.RELEASE")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
