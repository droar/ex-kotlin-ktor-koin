val kotlin_version: String by project
val logback_version: String by project

val junit_version: String by project
val mockk_version: String by project
val kotest_version: String by project

plugins {
    kotlin("jvm") version "1.9.10"
    id("io.kotest.multiplatform") version "5.0.2"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "com.droar.samples.ktor"
version = "0.0.1"

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.droar.samples.ktor:ex-domain")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
    testImplementation("io.mockk:mockk:$mockk_version")
    testImplementation("io.kotest:kotest-assertions-core:$kotest_version")
    testImplementation("io.kotest:kotest-property:$kotest_version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
}
