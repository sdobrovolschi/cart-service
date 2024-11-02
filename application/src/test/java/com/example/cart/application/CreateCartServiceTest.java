package com.example.cart.application;

import com.example.cart.domain.Cart;
import com.example.cart.domain.Carts;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@MockitoSettings
@Tag("unit")
class CreateCartServiceTest {

    @Mock
    Carts carts;

    @Captor
    ArgumentCaptor<Cart> cartArgumentCaptor;

    @InjectMocks
    CreateCartService service;

    @Test
    void creation() {
        var cartId = service.createCart();

        verify(carts).add(cartArgumentCaptor.capture());

        assertThat(cartArgumentCaptor.getValue())
                .extracting(Cart::getId)
                .isEqualTo(cartId);
    }
}
