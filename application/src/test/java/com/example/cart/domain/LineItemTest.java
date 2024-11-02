package com.example.cart.domain;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class LineItemTest {

    @Test
    void creation() {
        var id = ItemId.newIdentity();
        var product = new Product(new ProductId(randomUUID()), Money.of(TEN, "EUR"));
        var quantity = new Quantity(3);

        var lineItem = new LineItem(id, product, quantity);

        assertThat(lineItem)
                .extracting(
                        LineItem::getId,
                        LineItem::getProduct,
                        LineItem::getQuantity,
                        LineItem::getPrice
                )
                .containsExactly(
                        id,
                        product,
                        quantity,
                        Money.of(BigDecimal.valueOf(30), "EUR")
                );
    }

    @Test
    void getIdIsRequired() {
        var product = new Product(new ProductId(randomUUID()), Money.of(TEN, "EUR"));
        var quantity = new Quantity(3);

        assertThatNullPointerException()
                .isThrownBy(() -> new LineItem(null, product, quantity))
                .withMessage("id must not be null");
    }

    @Test
    void getProductIsRequired() {
        var id = ItemId.newIdentity();
        var quantity = new Quantity(3);

        assertThatNullPointerException()
                .isThrownBy(() -> new LineItem(id, null, quantity))
                .withMessage("product must not be null");
    }

    @Test
    void getQuantityIsRequired() {
        var id = ItemId.newIdentity();
        var product = new Product(new ProductId(randomUUID()), Money.of(TEN, "EUR"));

        assertThatNullPointerException()
                .isThrownBy(() -> new LineItem(id, product, null))
                .withMessage("quantity must not be null");
    }
}
