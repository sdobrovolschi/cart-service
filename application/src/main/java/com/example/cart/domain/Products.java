package com.example.cart.domain;

import java.util.Optional;

public interface Products {

    Optional<Product> find(ProductId id);
}
