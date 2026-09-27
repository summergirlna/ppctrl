package com.example.ppctrl.domain;

import lombok.Getter;

/// PPチェックの実行結果
@Getter
public enum ResultStatus {
    OK(0),
    WARNING(1),
    NG(2),
    UNKNOWN(3);

    private final int exitCode;

    ResultStatus(int exitCode) {
        this.exitCode = exitCode;
    }
}
