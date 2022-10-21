import kotlinx.kover.api.DefaultIntellijEngine

plugins {
    java
    id("org.jetbrains.kotlinx.kover")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter-test")
                implementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
                implementation("io.kotest:kotest-runner-junit5:5.5.1")
            }
        }

        val integrationTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project)
                implementation("org.springframework.boot:spring-boot-starter-test")
                implementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
                implementation("io.kotest:kotest-runner-junit5:5.5.1")
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

kover {
    isDisabled.set(false)
    engine.set(DefaultIntellijEngine) // to change engine, use kotlinx.kover.api.IntellijEngine("xxx") or kotlinx.kover.api.JacocoEngine("xxx")

    htmlReport {
        onCheck.set(true)
    }

    verify {
        onCheck.set(true)
        rule { // add verification rule
            isEnabled = true
            name = null // custom name for the rule
            target = kotlinx.kover.api.VerificationTarget.ALL // specify by which entity the code for separate coverage evaluation will be grouped

            bound { // add rule bound
                minValue = 50
                counter = kotlinx.kover.api.CounterType.LINE // change coverage metric to evaluate (LINE, INSTRUCTION, BRANCH)
                valueType = kotlinx.kover.api.VerificationValueType.COVERED_PERCENTAGE // change counter value (COVERED_COUNT, MISSED_COUNT, COVERED_PERCENTAGE, MISSED_PERCENTAGE)
            }
        }
    }
}