package com.example.cart.domain;

import java.util.Optional;

public interface Carts {

    void add(Cart cart);

    Optional<Cart> find(CartId cartId);
}
