plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://repo.spring.io/release") }
}

dependencies {
    // kotlin-conventions
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21") // jvm
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.3.0") // code format

    // spring-conventions
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.4")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.6.21")

    // testing-conventions
    implementation("org.jetbrains.kotlinx:kover:0.6.1") // code coverage
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.14.0") //code reformat
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:5.0.13") //find bug
}
