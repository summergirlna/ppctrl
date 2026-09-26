package com.example.ppctrl.domain;

import java.util.Objects;

public record ActionRequest(
        String product,
        Action action
) {
    public ActionRequest {
        Objects.requireNonNull(product, "product must not be null");
        Objects.requireNonNull(action, "action must not be null");

        product = product.trim();
        if (product.isEmpty()) {
            throw new IllegalArgumentException("product must not be empty");
        }
    }
}
