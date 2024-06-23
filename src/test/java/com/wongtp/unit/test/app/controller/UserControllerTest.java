/*
 * Copyleft
 */
package com.wongtp.unit.test.app.controller;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.wongtp.unit.test.app.entity.request.UserRequest;
import com.wongtp.unit.test.app.entity.response.Response;
import com.wongtp.unit.test.app.entity.response.ResponseCode;
import com.wongtp.unit.test.app.service.UserService;
import com.wongtp.unit.test.framework.core.AbstractMvcTest;
import com.wongtp.unit.test.framework.util.MockMvcUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wongtp
 * @date 2024-06-21
 */
class UserControllerTest extends AbstractMvcTest {

    private static final String ADD_USER_URL = "/user/addUser";

    @MockBean
    private UserService userService;

    @Test
    void should_validate_add_user_params_not_pass() throws Exception {
        Response<String> resp = addUser("test username too long =======================================================");
        Assertions.assertNotEquals(resp.getCode(), ResponseCode.SUCCESS.getCode());
    }

    @Test
    void should_add_user_success() throws Exception {
        when(userService.addUser(any())).thenReturn(true);

        Response<String> resp = addUser("test_username");
        Assertions.assertEquals(resp.getCode(), ResponseCode.SUCCESS.getCode());
    }

    private Response<String> addUser(String username) throws Exception {
        UserRequest reqt = new UserRequest();
        reqt.setPhone("13800000000");
        reqt.setUsername(username);
        reqt.setUuid(UUID.randomUUID().toString());

        MvcResult mvcResult = mockMvc.perform(MockMvcUtil.post(ADD_USER_URL, reqt))
                .andExpect(status().isOk())
                .andReturn();
        String body = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        return JSONUtil.toBean(body, new TypeReference<Response<String>>() { }, false);
    }
}