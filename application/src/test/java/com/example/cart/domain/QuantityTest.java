package com.example.cart.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@Tag("unit")
class QuantityTest {

    @Test
    void creation() {
        var value = 3;

        assertThat(new Quantity(value))
                .extracting(Quantity::value)
                .isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void valueIsGreaterThanZero(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Quantity(value))
                .withMessage("value must be greater than 0");
    }
}
