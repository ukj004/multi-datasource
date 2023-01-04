package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class DemoApplicationIT {

    private WebTestClient client;

    @BeforeEach
    public void setup() {
        this.client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8091")
                .build();
    }

    @Test
    public void willLoadDatasource1Customers() {
        this.client.get().uri("/customers/getAll/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void willLoadDatasource2Customers() {
        this.client.get().uri("/customers/getAll/2")
                .exchange()
                .expectStatus().isOk();
    }

}