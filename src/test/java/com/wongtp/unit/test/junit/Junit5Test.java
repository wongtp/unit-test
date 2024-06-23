/*
 * Copyleft
 */
package com.wongtp.unit.test.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@Tag("Junit5Test tag")
@Tags({@Tag("tag1"), @Tag("tag2")})
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
// 配置测试生命周期为共用一个实例
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Junit5Test {

    String uuid = UUID.randomUUID().toString();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach-" +  uuid);
    }

    @Test
    @Timeout(1000L)
    @DisplayName("startTestName")
    public void startTest() {
        System.out.println("startTest");
    }

    @RepeatedTest(2)
    public void repeatedTest() {
        System.out.println("repeatedTest");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void parameterizedTest(int value) {
        System.out.println("parameterized: " + value);
    }

    @Test
    @Disabled("==== disabled and skip ====")
    public void disabled() {
        System.out.println("==== disabled ====");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("afterAll");
    }
}
