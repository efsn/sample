package cn.elmi.sample.eureka

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @version 1.0
 * @authur Arthur
 */
@RestController
class TestClient(
    private val client: DiscoveryClient
) {

    @GetMapping("/hello")
    fun hello(): String {
        val instance = client.getInstances("hello-service")[0]
//        log.info("serviceId{} host:post={}:{}", instance.serviceId, instance.host, instance.port)
        return "hello eureka client."
    }
}