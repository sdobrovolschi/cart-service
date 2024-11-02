CREATE TABLE line_item
(
    id   UUID        NOT NULL,
    cart_id UUID NOT NULL,
    product_id UUID NOT NULL,
    product_price_amount NUMERIC NOT NULL,
    product_price_currency VARCHAR(3) NOT NULL,
    quantity NUMERIC NOT NULL,
    CONSTRAINT pk_line_item PRIMARY KEY (id, cart_id),
    FOREIGN KEY (cart_id) REFERENCES cart(id)
);
