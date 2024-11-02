package com.example.cart.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit")
class CartTest {

    @Test
    void creation() {
        var id = CartId.newIdentity();

        var cart = new Cart(id);

        assertThat(cart)
                .extracting(
                        Cart::getId,
                        Cart::getLineItems)
                .containsExactly(id, emptyList());
    }
}
