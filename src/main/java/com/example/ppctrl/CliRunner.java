package com.example.ppctrl;

import com.example.ppctrl.application.ExecuteActionUseCase;
import com.example.ppctrl.domain.Action;
import com.example.ppctrl.domain.ActionRequest;
import com.example.ppctrl.domain.ActionResult;
import com.example.ppctrl.presentation.output.ActionResultFormatter;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CliRunner implements ApplicationRunner {

  @NonNull private final ExecuteActionUseCase useCase;

  @NonNull private final ActionResultFormatter formatter;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    String product = requiredOption(args, "product");
    String action = requiredOption(args, "action");

    ActionResult result = useCase.execute(new ActionRequest(product, new Action(action)));

    System.out.println(formatter.format(result));
  }

  private String requiredOption(ApplicationArguments args, String name) {
    List<String> values = args.getOptionValues(name);
    if (values == null || values.isEmpty() || values.getFirst().isBlank()) {
      throw new IllegalArgumentException("Missing required option: --" + name);
    }
    return values.getFirst();
  }
}
