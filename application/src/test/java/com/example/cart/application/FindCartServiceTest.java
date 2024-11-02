package com.example.cart.application;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;
import com.example.cart.domain.Carts;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@MockitoSettings
@Tag("unit")
class FindCartServiceTest {

    @Mock
    Carts carts;

    @InjectMocks
    FindCartService service;

    @Test
    void finding() {
        var cartId = CartId.newIdentity();
        var cart = new Cart(cartId);

        when(carts.find(cartId)).thenReturn(Optional.of(cart));

        assertThat(service.find(cartId))
                .contains(cart);
    }
}
