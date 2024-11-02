package com.example.cart.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class ProductIdTest {

    @Test
    void creation() {
        var value = randomUUID();

        assertThat(new ProductId(value))
                .extracting(ProductId::value)
                .isEqualTo(value);
    }

    @Test
    void valueIsRequired() {
        assertThatNullPointerException()
                .isThrownBy(() -> new ProductId(null))
                .withMessage("value must not be null");
    }
}
