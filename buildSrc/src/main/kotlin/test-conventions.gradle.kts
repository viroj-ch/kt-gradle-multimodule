import kotlinx.kover.api.DefaultIntellijEngine

plugins {
    java
    id("org.jetbrains.kotlinx.kover")
    id("com.diffplug.spotless")
    id("com.github.spotbugs")
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.5.1")
    testImplementation("io.mockk:mockk:1.13.2")

    spotbugs("org.slf4j:slf4j-nop:1.7.36")
    spotbugs("com.github.spotbugs:spotbugs:4.1.4")
    spotbugsPlugins("com.h3xstream.findsecbugs:findsecbugs-plugin:1.12.0")
}

spotbugs {
    effort.set(com.github.spotbugs.snom.Effort.MAX)
    excludeFilter.set(file("../spotbugs-exclude.xml")) // relative from module that plugins this convention file
    includeFilter.set(file("../spotbugs-include.xml")) // relative from module that plugins this convention file
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
