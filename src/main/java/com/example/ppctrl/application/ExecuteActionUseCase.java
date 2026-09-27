package com.example.ppctrl.application;

import com.example.ppctrl.domain.ActionRequest;
import com.example.ppctrl.domain.ActionResult;
import com.example.ppctrl.domain.ProductOperator;

public class ExecuteActionUseCase {

    private final ProductOperator productOperator;

    public ExecuteActionUseCase(ProductOperator productOperator) {
        this.productOperator = productOperator;
    }

    public ActionResult execute(ActionRequest request) {
        return productOperator.execute(request);
    }
}
