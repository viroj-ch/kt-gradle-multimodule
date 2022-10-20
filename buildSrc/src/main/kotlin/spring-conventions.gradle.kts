plugins {
    `java-library`
    kotlin("plugin.spring") // is a wrapper on top of all-open
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}
