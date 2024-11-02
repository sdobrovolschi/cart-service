package com.example.cart.domain;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.TEN;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class ProductTest {

    @Test
    void creation() {
        var id = new ProductId(randomUUID());
        var price = Money.of(TEN, "EUR");

        var product = new Product(id, price);

        assertThat(product)
                .extracting(Product::getId, Product::getPrice)
                .containsExactly(id, price);
    }

    @Test
    void getIdIsRequired() {
        var price = Money.of(TEN, "EUR");

        assertThatNullPointerException()
                .isThrownBy(() -> new Product(null, price))
                .withMessage("id must not be null");
    }

    @Test
    void getPriceIsRequired() {
        var id = new ProductId(randomUUID());

        assertThatNullPointerException()
                .isThrownBy(() -> new Product(id, null))
                .withMessage("price must not be null");
    }
}
