package com.example.cart.persistence;

import com.example.cart.domain.Cart;
import com.example.cart.domain.CartId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
class CartRecord {

    @Id
    UUID id;
    @OneToMany
    @JoinColumn(name = "cart_id")
    List<LineItemRecord> lineItems;

    static CartRecord from(Cart cart) {
        var lineItems = cart.getLineItems().stream()
                .map(LineItemRecord::from)
                .toList();

        return new CartRecord(cart.getId().value(), lineItems);
    }

    Cart toCart() {
        return new Cart(new CartId(id), lineItems.stream()
                .map(LineItemRecord::toLineItem)
                .toList());
    }
}
