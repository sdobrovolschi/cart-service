package com.example.cart.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class ItemIdTest {

    @Test
    void creation() {
        var value = randomUUID();

        assertThat(new ItemId(value))
                .extracting(ItemId::value)
                .isEqualTo(value);
    }

    @Test
    void generation() {
        assertThat(ItemId.newIdentity())
                .as("non idempotent")
                .isNotEqualTo(ItemId.newIdentity());
    }

    @Test
    void valueIsRequired() {
        assertThatNullPointerException()
                .isThrownBy(() -> new ItemId(null))
                .withMessage("value must not be null");
    }
}
