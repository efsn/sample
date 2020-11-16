dependencies {
    testImplementation "org.junit.jupiter:junit-jupiter:5.4.2"
}

tasks {
    test {
        failFast = true
        useJUnitPlatform()
        testLogging { events("passed", "skipped", "failed") }
    }
}






