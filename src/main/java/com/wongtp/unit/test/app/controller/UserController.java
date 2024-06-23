/*
 * Copyleft
 */
package com.wongtp.unit.test.app.controller;

import com.wongtp.unit.test.app.entity.UserEntity;
import com.wongtp.unit.test.app.entity.request.UserRequest;
import com.wongtp.unit.test.app.entity.response.Response;
import com.wongtp.unit.test.app.entity.response.ResponseCode;
import com.wongtp.unit.test.app.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wongtp
 * @date 2024-06-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/addUser")
    public Response<String> addUser(@RequestBody @Validated UserRequest userRequest) {
        boolean added = userService.addUser(new UserEntity(userRequest));
        return added ? Response.success() : Response.fail(ResponseCode.SYSTEM_ERROR);
    }
}
