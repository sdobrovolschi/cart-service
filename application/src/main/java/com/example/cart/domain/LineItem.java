package com.example.cart.domain;

import javax.money.MonetaryAmount;
import java.util.Objects;

public final class LineItem {

    private final ItemId id;
    private final Product product;
    private Quantity quantity;

    public LineItem(ItemId id, Product product, Quantity quantity) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.product = Objects.requireNonNull(product, "product must not be null");
        this.quantity = Objects.requireNonNull(quantity, "quantity must not be null");
    }

    public ItemId getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public MonetaryAmount getPrice() {
        return product.getPrice().multiply(quantity.value());
    }
}
