plugins {
    id("kotlin-conventions")
    id("spring-conventions")
    id("test-conventions")
    id("integration-test-conventions")
}

dependencies {
    implementation(project(":domain"))

    integrationTestImplementation("com.github.tomakehurst:wiremock:2.19.0") // for demo, not yet use it
}
