package com.example.ppctrl;

import com.example.ppctrl.application.ExecuteActionUseCase;
import com.example.ppctrl.domain.Action;
import com.example.ppctrl.domain.ActionRequest;
import com.example.ppctrl.domain.ActionResult;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CliRunner implements ApplicationRunner {

    private final ExecuteActionUseCase useCase;

    public CliRunner(ExecuteActionUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String product = requiredOption(args, "product");
        String action = requiredOption(args, "action");

        ActionResult result = useCase.execute(
                new ActionRequest(product, new Action(action))
        );

        System.out.println(result);
    }

    private String requiredOption(ApplicationArguments args, String name) {
        List<String> values = args.getOptionValues(name);
        if (values == null || values.isEmpty() || values.getFirst().isBlank()) {
            throw new IllegalArgumentException("Missing required option: --" + name);
        }
        return values.getFirst();
    }
}
