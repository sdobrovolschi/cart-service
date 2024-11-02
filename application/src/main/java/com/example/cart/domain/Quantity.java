package com.example.cart.domain;

public record Quantity(int value) {

    public Quantity {
        if (value < 1) {
            throw new IllegalArgumentException("value must be greater than 0");
        }
    }
}
