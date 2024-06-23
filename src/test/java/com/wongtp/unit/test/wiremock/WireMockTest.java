/*
 * Copyleft
 */
package com.wongtp.unit.test.wiremock;

import com.wongtp.unit.test.app.service.UserService;
import com.wongtp.unit.test.framework.core.AbstractWireMockTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

/**
 * @author wongtp
 * @date 2024-06-23
 */
public class WireMockTest extends AbstractWireMockTest {

    private static final String FIX_TOKEN = UUID.randomUUID().toString();

    @Resource
    private UserService userService;

    @BeforeAll
    public static void setup() {
        stubFor(get(urlEqualTo(UserService.APPLY_TOKEN_URL))
                .willReturn(ok().withBody(FIX_TOKEN)));
    }

    @Test
    public void post_request_to_server_success() {
        userService.setTokenServerHost(mockServer.baseUrl());

        String token = userService.applyToken();
        Assertions.assertEquals(token, FIX_TOKEN);
    }
}
