package com.example.ppctrl.infrastructure;

import com.example.ppctrl.domain.ActionRequest;
import com.example.ppctrl.domain.ActionResult;
import com.example.ppctrl.domain.ProductOperator;
import com.example.ppctrl.domain.ResultStatus;
import java.time.Instant;
import org.springframework.stereotype.Component;

@Component
public class DummyProductOperator implements ProductOperator {

  @Override
  public ActionResult execute(ActionRequest request) {
    Instant now = Instant.now();

    return new ActionResult(
        request.product(),
        request.action(),
        "dummy",
        ResultStatus.OK,
        "Dummy action completed.",
        now,
        now);
  }
}
