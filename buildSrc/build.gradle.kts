plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/release") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.6.10")

    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.3")
    implementation("org.springframework.experimental:spring-aot-gradle-plugin:0.12.1")
}
