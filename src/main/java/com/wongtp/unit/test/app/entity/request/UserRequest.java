/*
 * Copyleft
 */
package com.wongtp.unit.test.app.entity.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Data
public class UserRequest {

    private Integer id;

    @NotNull
    private String phone;

    @NotNull(message = "username must be not null")
    @Length(min = 1, max = 20, message = "length must be between 1 and 20")
    private String username;

    @NotNull
    private String uuid;

}
