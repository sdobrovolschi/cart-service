package com.example.cart.resource;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public final class OptionalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.isOptional();
    }

    @Override
    public Object beforeBodyWrite(
            @Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {

        if (body == null) {
            return null;
        }

        var optionalBody = (Optional<?>) body;

        if (optionalBody.isPresent()) {
            return optionalBody.get();
        }

        response.setStatusCode(NOT_FOUND);

        return ProblemDetail.forStatus(NOT_FOUND);
    }
}
