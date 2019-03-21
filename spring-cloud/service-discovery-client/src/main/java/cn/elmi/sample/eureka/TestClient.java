package cn.elmi.sample.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @authur Arthur
 */
@Slf4j
@RestController
public class TestClient {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance instance = client.getInstances("hello-service").get(0);
        log.info("serviceId{} host:post={}:{}", instance.getServiceId(), instance.getHost(), instance.getPort());
        return "hello eureka client.";

    }

}
