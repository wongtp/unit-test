/*
 * Copyleft
 */
package com.wongtp.unit.test.app.entity;

import com.wongtp.unit.test.app.entity.request.UserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Data
@NoArgsConstructor
public class UserEntity {

    private Integer id;

    private String phone;

    private String username;

    private String uuid;

    public UserEntity(UserRequest request) {
        this.phone = request.getPhone();
        this.username = request.getUsername();
        this.uuid = request.getUuid();
    }

    public void throwException() {
        throw new IllegalStateException("hello exception");
    }

}
