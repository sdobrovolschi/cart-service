package com.example.cart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public final class Cart {

    private final CartId id;
    private final List<LineItem> lineItems;

    public Cart(CartId id) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.lineItems = new ArrayList<>();
    }

    public Cart(CartId id, List<LineItem> lineItems) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.lineItems = Objects.requireNonNull(lineItems, "lineItems must not be null");
    }

    public CartId getId() {
        return id;
    }

    public List<LineItem> getLineItems() {
        return unmodifiableList(lineItems);
    }
}
