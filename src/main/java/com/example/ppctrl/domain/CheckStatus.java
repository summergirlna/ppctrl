package com.example.ppctrl.domain;

/// PPチェックの実行結果
public enum CheckStatus {
    OK(0),
    WARNING(1),
    NG(2),
    UNKNOWN(3);

    private final int exitCode;

    CheckStatus(int exitCode) {
        this.exitCode = exitCode;
    }

    public int exitCode() {
        return exitCode;
    }
}
