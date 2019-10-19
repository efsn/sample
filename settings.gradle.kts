rootProject.name = "sample"

// multiple level modules
files("spring-cloud").forEach { dir ->
    dir.listFiles().forEach {
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

//inclunde "amqp"
