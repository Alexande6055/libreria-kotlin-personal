plugins {
    kotlin("jvm") version "2.2.0"
}

group = "com.gestionplus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
tasks.register<Jar>("buildJar") {
    archiveBaseName.set("persona-ec-lib")
    archiveVersion.set("1.0.0")           // versión
    from(sourceSets.main.get().output)
}
