package com.example.cart.application;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;
import com.example.cart.domain.Carts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreateCartService implements CreateCartUseCase {

    private final Carts carts;

    @Override
    public CartId createCart() {
        var cart = new Cart(CartId.newIdentity());

        carts.add(cart);

        return cart.getId();
    }
}
