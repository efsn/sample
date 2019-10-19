dependencies {
    implementation(project(":mybatis"))

    implementation("org.springframework.boot:spring-boot-starter-web:")
    implementation("org.aspectj:aspectjrt")
    implementation("org.aspectj:aspectjweaver")
    implementation("org.apache.commons:commons-lang3:3.7")

    tasks.named("compileJava") {
        dependsOn("processResources")
    }
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
