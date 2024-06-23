/*
 * Copyleft
 */
package com.wongtp.unit.test.app.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private int code;

    private String message;

    private T data;

    public static <T> Response<T> success() {
        return new Response<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> Response<T> fail(ResponseCode code) {
        return new Response<>(code.getCode(), code.getMessage(), null);
    }

    public static <T> Response<T> fail(ResponseCode code, String errorMsg) {
        return new Response<>(code.getCode(), errorMsg, null);
    }
}
