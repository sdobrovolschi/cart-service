package com.example.cart;

import au.com.dius.pact.provider.junitsupport.State;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
class CartStateHandler implements StateHandler {

    @Value("${embedded.service.port}")
    int port;

    @State("a an empty cart")
    Map<String, String> emptyCart() {
        var client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();

        var uri = client.post().uri("/carts")
                .exchange()
                .returnResult(Void.class)
                .getResponseHeaders()
                .getLocation();

        var cartId = UriComponentsBuilder.fromUri(uri)
                .build()
                .getPathSegments()
                .getLast();

        return Map.of("cartId", cartId);
    }
}
