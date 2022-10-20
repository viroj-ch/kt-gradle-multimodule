plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/release") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.7.20")

    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.4")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.3.0")
}
