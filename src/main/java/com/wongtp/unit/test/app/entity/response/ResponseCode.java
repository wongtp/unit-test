/*
 * Copyleft
 */
package com.wongtp.unit.test.app.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wongtp
 * @date 2024-06-22
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SYSTEM_ERROR(-2, "SYSTEM_ERROR"),
    UNKNOWN(-1, "UNKNOWN"),
    SUCCESS(0, "SUCCESS"),
    ACCOUNT_NOT_EXISTS(1, "ACCOUNT_NOT_EXISTS"),
    PARAM_NOT_VALID(2, "PARAM_NOT_VALID");

    private final int code;
    private final String message;
}
