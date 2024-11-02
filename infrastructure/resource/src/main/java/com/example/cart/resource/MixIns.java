package com.example.cart.resource;

import com.fasterxml.jackson.annotation.JsonValue;

public interface MixIns {

    interface CardIdMixIn {

        @JsonValue
        String value();
    }

}
