import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// PLUGINS -- BEGIN
plugins {
    kotlin("jvm") version "1.5.30"
    `java-library`
}

allprojects {
    apply(plugin = "kotlin")
}
// PLUGINS -- END

// JAVA VERSION -- BEGIN
allprojects {
    java.sourceCompatibility = JavaVersion.VERSION_11

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
// JAVA VERSION -- END

// NULLABILITY -- BEGIN
allprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}
// NULLABILITY -- END

// SOURCES -- BEGIN
allprojects {
    java {
        withSourcesJar()
    }
}
// SOURCES -- END

// JAVADOC -- BEGIN
allprojects {
    java {
        withJavadocJar()
    }
}
// JAVADOC -- END

// TEST LOGGING -- BEGIN
allprojects {
    tasks.withType<Test> {
        testLogging {
            showStandardStreams = false
            events("skipped", "failed")
            showExceptions = true
            showCauses = true
            showStackTraces = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
        afterSuite(printTestResult)
    }
}

val printTestResult: KotlinClosure2<TestDescriptor, TestResult, Void>
    get() = KotlinClosure2({ desc, result ->

        if (desc.parent == null) { // will match the outermost suite
            println("------")
            println(
                "Results: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} " +
                        "successes, ${result.failedTestCount} failures, ${result.skippedTestCount} skipped)"
            )
            println(
                "Tests took: ${result.endTime - result.startTime} ms."
            )
            println("------")
        }
        null
    })
// TEST LOGGING -- END

// JUNIT -- BEGIN
allprojects {
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
// JUNIT -- END

// Dependencies -- BEGIN
allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
    testImplementation("org.assertj:assertj-core:3.20.2")
}
