package com.example.ppctrl.presentation.output;

import com.example.ppctrl.domain.ActionResult;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class LegacyActionResultFormatter implements ActionResultFormatter {

  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss").withZone(ZoneId.systemDefault());

  @Override
  public String format(ActionResult result) {
    String startedAt = DATE_TIME_FORMATTER.format(result.startedAt());
    String endedAt = DATE_TIME_FORMATTER.format(result.endedAt());

    return """
                %s ppctrl %s %s %s start.
                %s ppctrl %s %s %s end.(result = %s, message = %s)
                """
        .formatted(
            startedAt,
            result.product(),
            result.action().name(),
            result.checkType(),
            endedAt,
            result.product(),
            result.action().name(),
            result.checkType(),
            result.status(),
            result.message())
        .stripTrailing();
  }
}
