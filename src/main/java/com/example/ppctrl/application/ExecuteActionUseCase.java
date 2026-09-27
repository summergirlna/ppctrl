package com.example.ppctrl.application;

import com.example.ppctrl.domain.ActionRequest;
import com.example.ppctrl.domain.ActionResult;
import com.example.ppctrl.domain.ProductOperator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExecuteActionUseCase {

  @NonNull private final ProductOperator productOperator;

  public ActionResult execute(ActionRequest request) {
    return productOperator.execute(request);
  }
}
