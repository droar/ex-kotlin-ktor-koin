val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

val postgres_version: String by project
val h2_version: String by project
val junit_version: String by project
val mockk_version: String by project
val kotest_version: String by project
val koin_version: String by project

plugins {
    kotlin("jvm") version "1.9.10"
    id("io.kotest.multiplatform") version "5.0.2"
    id("io.ktor.plugin") version "2.3.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "com.droar.samples.ktor"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.droar.samples.ktor:ex-domain")
    api("io.insert-koin:koin-core:$koin_version")
    api("io.ktor:ktor-server-core-jvm")
    api("io.ktor:ktor-server-content-negotiation-jvm")
    api("io.ktor:ktor-serialization-kotlinx-json-jvm")
    api("io.ktor:ktor-server-default-headers-jvm")
    api("io.ktor:ktor-server-config-yaml:2.3.3")
    api("org.postgresql:postgresql:$postgres_version")
    api("com.h2database:h2:$h2_version")
    api("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
    testImplementation("io.mockk:mockk:$mockk_version")
    testImplementation("io.kotest:kotest-assertions-core:$kotest_version")
    testImplementation("io.kotest:kotest-property:$kotest_version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
}
