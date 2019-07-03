package cn.elmi.sample.gateway;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"httpbin=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
public class ApplicationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void contextLoads() throws Exception {
        // Stubs
        stubFor(get(urlEqualTo("/get"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"headers\":{\"Hello\":\"World\"}}")));

        stubFor(get(urlEqualTo("/delay/3"))
                .willReturn(aResponse()
                        .withFixedDelay(3000)
                        .withBody("no fallback")));

        webClient.get()
                .uri("/get")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.headers.Hello").isEqualTo("World");

        webClient.get()
                .uri("/delay/3")
                .header("Host", "mock.hystrix.com")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(r -> Assertions.assertThat(r.getResponseBody()).isEqualTo("fallback".getBytes()));
    }

}
