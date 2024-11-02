package com.example.cart.application;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;
import com.example.cart.domain.Carts;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public final class FindCartService implements FindCartUseCase {

    private final Carts carts;

    @Override
    public Optional<Cart> find(CartId cartId) {
        return carts.find(cartId);
    }
}
