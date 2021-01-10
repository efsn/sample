import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
    kotlin("plugin.jpa") version "1.4.21"
    id("org.springframework.boot") version "2.3.6.RELEASE"
}

// apply(from = rootProject.file("gradle/build-dependencies.gradle"))

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(from = rootProject.file("gradle/ktlint.gradle.kts"))

    group = "cn.elmi.sample"
    version = "1.0-SNAPSHOT"

/*
    sourceCompatibility = 1.8
    targetCompatibility = 1.8

    [compileJava, compileTestJava, javadoc]*.options*.encoding = "UTF-8"

    configurations {
        all*.exclude module: ["commons-logging", "commons-lang", "guava"]
    }

    dependencyManagement {
        imports {
            mavenBom lib.spring.boot.dependencies
            mavenBom "org.springframework.cloud:spring-cloud-dependencies:Greenwich.SR3"
        }
    }
*/
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation(kotlin("reflect"))
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        implementation(platform(SpringBootPlugin.BOM_COORDINATES))
        implementation(platform("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR9"))

        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.slf4j:slf4j-api")
        implementation("ch.qos.logback:logback-core")
        implementation("ch.qos.logback:logback-classic")

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage")
        }
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }

        bootJar {
            launchScript()
        }

        test {
            failFast = true
            useJUnitPlatform()
            testLogging {
                events("passed", "skipped", "failed")
            }
        }
    }
}