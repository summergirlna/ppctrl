package com.example.ppctrl.domain;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public record ActionResult(
    String product,
    Action action,
    String checkType,
    ResultStatus status,
    String message,
    Instant startedAt,
    Instant endedAt) {
  public ActionResult {
    Objects.requireNonNull(product, "product must not be null");
    Objects.requireNonNull(action, "action must not be null");
    Objects.requireNonNull(checkType, "checkType must not be null");
    Objects.requireNonNull(status, "status must not be null");
    Objects.requireNonNull(message, "message must not be null");
    Objects.requireNonNull(startedAt, "startedAt must not be null");
    Objects.requireNonNull(endedAt, "endedAt must not be null");
  }

  public Duration duration() {
    return Duration.between(startedAt, endedAt);
  }

  public int exitCode() {
    return status.getExitCode();
  }
}
