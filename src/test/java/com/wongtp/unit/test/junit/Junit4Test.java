/*
 * Copyleft
 */
package com.wongtp.unit.test.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite.SuiteClasses;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@RunWith(Parameterized.class)
@SuiteClasses(Junit4Test.class)
// 按照 @Test 标记的测试方法的名字排序顺序来执行
@OrderWith(Alphanumeric.class)
public class Junit4Test {

    @Rule
    public final TestRule globalTimeout = Timeout.millis(10);

    private int a;

    private int b;

    public Junit4Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Parameters
    public static Collection<?> data() {
        System.out.println("0.parameters data");
        return Arrays.asList(new Object[][] {{2, 4}, {1, 2}});
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("1.beforeClass");
    }

    @Before
    public void before() {
        System.out.println("2.before");
    }

    @Test(timeout = 1000, expected = NullPointerException.class)
    public void startTest() {
        System.out.println("3.startTest:" + (a + b));
        throw new NullPointerException();
    }

    @After
    public void after() {
        System.out.println("4.after");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("5.afterClass");
    }

    @Test
    @Ignore
    public void ignore() {
        System.out.println("==== ignore ====");
    }
}
