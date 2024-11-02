package com.example.cart.domain;

import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.randomUUID;

public record CartId(UUID value) {

    public CartId {
        requireNonNull(value, "value must not be null");
    }

    public static CartId newIdentity() {
        return new CartId(randomUUID());
    }
}
