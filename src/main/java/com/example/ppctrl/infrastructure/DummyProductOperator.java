package com.example.ppctrl.infrastructure;

import com.example.ppctrl.domain.ActionRequest;
import com.example.ppctrl.domain.ActionResult;
import com.example.ppctrl.domain.ProductOperator;
import com.example.ppctrl.domain.ResultStatus;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DummyProductOperator implements ProductOperator {

    @Override
    public ActionResult execute(ActionRequest request) {
        Instant startedAt = Instant.now();
        Instant endedAt = Instant.now();

        return new ActionResult(
                request.product(),
                request.action(),
                "dummy",
                ResultStatus.OK,
                "Dummy action completed.",
                startedAt,
                endedAt
        );
    }
}
