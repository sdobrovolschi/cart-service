package com.example.cart.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class CartIdTest {

    @Test
    void creation() {
        var value = randomUUID();

        assertThat(new CartId(value))
                .extracting(CartId::value)
                .isEqualTo(value);
    }

    @Test
    void generation() {
        assertThat(CartId.newIdentity())
                .as("non idempotent")
                .isNotEqualTo(CartId.newIdentity());
    }

    @Test
    void valueIsRequired() {
        assertThatNullPointerException()
                .isThrownBy(() -> new CartId(null))
                .withMessage("value must not be null");
    }
}
