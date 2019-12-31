dependencies {

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")



    implementation(platform("org.drools:drools-bom:7.31.0.Final"))
    implementation("org.kie:kie-api")
    runtimeOnly("org.drools:drools-compiler")

}
