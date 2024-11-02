package com.example.cart.domain;

import javax.money.MonetaryAmount;

import static java.util.Objects.requireNonNull;

public final class Product {

    private final ProductId id;
    private final MonetaryAmount price;

    public Product(ProductId id, MonetaryAmount price) {
        this.id = requireNonNull(id, "id must not be null");
        this.price = requireNonNull(price, "price must not be null");
    }

    public ProductId getId() {
        return id;
    }

    public MonetaryAmount getPrice() {
        return price;
    }
}
