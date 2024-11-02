package com.example.cart.persistence;

import com.example.cart.domain.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "line_item")
@AllArgsConstructor
@NoArgsConstructor
class LineItemRecord {

    @Id
    UUID id;
    UUID productId;
    BigDecimal productPriceAmount;
    String productPriceCurrency;
    int quantity;

    static LineItemRecord from(LineItem lineItem) {
        return new LineItemRecord(
                lineItem.getId().value(),
                lineItem.getProduct().getId().value(),
                lineItem.getProduct().getPrice().getNumber().numberValue(BigDecimal.class),
                lineItem.getProduct().getPrice().getCurrency().getCurrencyCode(),
                lineItem.getQuantity().value());
    }

    public LineItem toLineItem() {
        return new LineItem(
                new ItemId(id),
                new Product(new ProductId(productId), Money.of(productPriceAmount, productPriceCurrency)),
                new Quantity(quantity));
    }
}
