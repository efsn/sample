rootProject.name = "sample"

// multiple level modules
files("spring-cloud", "spring-cloud/feign-consumer", "spring-cloud/feign-producer").forEach { dir ->
    dir.listFiles()?.forEach {
        if (it.isDirectory) {
            include(it.name)
            project(":${it.name}").projectDir = it
        }
    }
}

include("data-structure", "functional")
include("spring-boot")
include("netty")
include("restful")
include("mybatis")
include("junit")
include("kotlin")
include("reactor")
include("webflux")
include("rule-engine")


include("feign-consumer")

//inclunde "amqp"
