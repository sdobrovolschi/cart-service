package com.example.cart.resource;

import com.example.cart.application.CreateCartUseCase;
import com.example.cart.application.FindCartUseCase;
import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping(path = "/carts")
@RequiredArgsConstructor
final class CartResource {

    private final CreateCartUseCase createCartUseCase;
    private final FindCartUseCase findCartUseCase;

    @PostMapping
    ResponseEntity<Void> create() {
        var cartId = createCartUseCase.createCart();

        return created(URI.create("/carts/" + cartId.value())).build();
    }

    @GetMapping(path = "/{cartId}")
    Optional<Cart> find(@PathVariable("cartId") UUID cartId) {
        return findCartUseCase.find(new CartId(cartId));
    }
}
