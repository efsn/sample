package cn.elmi.sample.feign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients("cn.elmi.sample.feign.service")
// @EnableEurekaClient
@SpringBootApplication
class Application

fun main() {
    runApplication<Application>()
}