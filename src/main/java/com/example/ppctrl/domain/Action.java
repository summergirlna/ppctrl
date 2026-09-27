package com.example.ppctrl.domain;

import java.util.Locale;
import java.util.Objects;

/// 各PPが実行可能なアクションの定義
public record Action(String name) {

  public static final Action START = new Action("start");
  public static final Action STOP = new Action("stop");
  public static final Action CHECK = new Action("check");
  public static final Action RESTART = new Action("restart");

  public Action {
    Objects.requireNonNull(name, "name must not be null");
    name = name.trim().toLowerCase(Locale.ROOT);
    if (name.isEmpty()) {
      throw new IllegalArgumentException("action name must not be empty");
    }
  }

  /// 判定対象のアクションが標準アクションか判定する
  ///
  /// @return 標準アクションの場合はtrue
  public boolean isStandard() {
    return name.equals(START.name)
        || name.equals(STOP.name)
        || name.equals(CHECK.name)
        || name.equals(RESTART.name);
  }
}
