package com.example.cart.persistence;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;
import com.example.cart.domain.Carts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
final class SpringDataJpaCartRepositoryAdapter implements Carts {

    private final SpringDataJpaCartRepository repository;

    @Override
    public void add(Cart cart) {
        repository.saveAndFlush(CartRecord.from(cart));
    }

    @Override
    public Optional<Cart> find(CartId cartId) {
        return repository.findById(cartId.value())
                .map(CartRecord::toCart);
    }
}
