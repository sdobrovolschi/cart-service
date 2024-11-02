package com.example.cart.domain;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public record ProductId(UUID value) {

    public ProductId {
        requireNonNull(value, "value must not be null");
    }
}
