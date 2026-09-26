package com.example.ppctrl.application;

import com.example.ppctrl.domain.CheckRequest;
import com.example.ppctrl.domain.CheckResult;
import com.example.ppctrl.domain.ProductChecker;

public class CheckUseCase {

    private final ProductChecker productChecker;

    public CheckUseCase(ProductChecker productChecker) {
        this.productChecker = productChecker;
    }

    public CheckResult check(CheckRequest request) {
        return productChecker.check(request);
    }
}
