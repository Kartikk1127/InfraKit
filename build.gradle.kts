plugins {
    kotlin("jvm") version "2.2.0"
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.infrakit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.infrakit.MainKt")
}
