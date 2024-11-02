package com.example.cart.application;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;

import java.util.Optional;

public interface FindCartUseCase {

    Optional<Cart> find(CartId cartId);
}
