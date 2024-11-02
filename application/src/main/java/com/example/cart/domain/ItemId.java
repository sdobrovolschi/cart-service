package com.example.cart.domain;

import java.util.UUID;

import static java.util.Objects.requireNonNull;
import static java.util.UUID.randomUUID;

public record ItemId(UUID value) {

    public ItemId {
        requireNonNull(value, "value must not be null");
    }

    public static ItemId newIdentity() {
        return new ItemId(randomUUID());
    }
}
