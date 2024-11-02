package com.example.cart.application;

import com.example.cart.domain.CartId;

import java.util.UUID;

public interface CreateCartUseCase {

    CartId createCart();
}
