package com.example.cart;

import com.example.cart.application.CreateCartService;
import com.example.cart.application.CreateCartUseCase;
import com.example.cart.application.FindCartService;
import com.example.cart.application.FindCartUseCase;
import com.example.cart.domain.Carts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    CreateCartUseCase createCartUseCase(Carts carts) {
        return new CreateCartService(carts);
    }

    @Bean
    FindCartUseCase findCartUseCase(Carts carts) {
        return new FindCartService(carts);
    }
}
