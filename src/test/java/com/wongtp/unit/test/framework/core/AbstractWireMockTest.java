/*
 * Copyleft
 */
package com.wongtp.unit.test.framework.core;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author wongtp
 * @date 2024-06-22
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractWireMockTest extends AbstractSpringBootTest {

    protected static WireMockServer mockServer = new WireMockServer();

    @BeforeAll
    @Order(1)
    public static void setupMockServer() {
        mockServer.start();
    }

    @AfterAll
    public static void destroyMockServer() {
        mockServer.stop();
    }
}
