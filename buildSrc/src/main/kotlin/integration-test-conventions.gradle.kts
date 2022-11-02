plugins {
    java
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter-test")
                implementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
                implementation("io.kotest:kotest-runner-junit5:5.5.1")
                implementation("io.mockk:mockk:1.13.2")
            }
        }

        val integrationTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project)
                implementation("org.springframework.boot:spring-boot-starter-test")
                implementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
                implementation("io.kotest:kotest-runner-junit5:5.5.1")
                implementation("io.mockk:mockk:1.13.2")
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}

tasks.named("check") {
    dependsOn(testing.suites.named("integrationTest"))
}

