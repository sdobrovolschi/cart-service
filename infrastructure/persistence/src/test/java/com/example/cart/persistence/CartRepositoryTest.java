package com.example.cart.persistence;

import com.example.cart.domain.*;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.UUID.fromString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@PersistenceTest
class CartRepositoryTest {

    @Autowired
    SpringDataJpaCartRepositoryAdapter adapter;

    @Test
    @ExpectedDataSet("datasets/cart.yml")
    void insertion() {
        var cart = new Cart(new CartId(fromString("fe5cea5a-71ce-44cd-9b7a-1aba11dc5a91")));

        adapter.add(cart);
    }

    @ParameterizedTest
    @MethodSource("selectionArgumentsProvider")
    @DataSet("datasets/carts.yml")
    void selection(CartId cartId, Cart expectedCart) {

        var cart = adapter.find(cartId);

        assertThat(cart)
                .usingRecursiveComparison()
                .isEqualTo(Optional.ofNullable(expectedCart));
    }

    static Stream<Arguments> selectionArgumentsProvider() {
        return Stream.of(
                arguments(
                        new CartId(fromString("fe5cea5a-71ce-44cd-9b7a-1aba11dc5a91")),
                        new Cart(new CartId(fromString("fe5cea5a-71ce-44cd-9b7a-1aba11dc5a91")))
                ),
                arguments(
                        new CartId(fromString("3889e913-a326-4e38-bf87-9e3088432ac5")),
                        new Cart(
                                new CartId(fromString("3889e913-a326-4e38-bf87-9e3088432ac5")),
                                List.of(new LineItem(
                                        new ItemId(fromString("130eee25-32ac-4240-a255-e7bdcb0b4e14")),
                                        new Product(new ProductId(fromString("1300b3d4-fb5a-441c-92ef-c5a11e20e089")),
                                                Money.of(BigDecimal.valueOf(125.75), "EUR")),
                                        new Quantity(3)))
                        )
                ),
                arguments(new CartId(UUID.randomUUID()), null)
        );
    }
}
