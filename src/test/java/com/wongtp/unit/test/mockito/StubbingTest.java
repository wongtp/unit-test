/*
 * Copyleft
 */
package com.wongtp.unit.test.mockito;

import com.wongtp.unit.test.app.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * 定义或者改变改该代理对象的行为
 * @author wongtp
 * @date 2024-06-21
 */
@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    /**
     * 使用 @Mock 注解来 mock 对象，需要和 @Rule、@RunWith 注解配套使用
     */
    @Mock
    public UserEntity userEntity;

    @Test(expected = IllegalArgumentException.class)
    public void stubbingTest() {
        // stubbing 有返回值方法的行为
        // thenReturn 为可变长度参数，用于多次调用被 stubbing 方法时返回不同值
        when(userEntity.getUuid()).thenReturn("uuid 1", "uuid 2");
        System.out.println(userEntity.getUuid());
        System.out.println(userEntity.getUuid());

        // 直接调用 service 对象的真实方法，而不是调用 service 代理对象的方法
        when(userEntity.getUuid()).thenCallRealMethod();
        System.out.println(userEntity.getUuid());

        // 自定义返回值处理逻辑，相对于 thenReturn() 有更多非 hardcode 方法定义返回值
        when(userEntity.getUuid()).thenAnswer(answer ->  "return by answer: " + answer.getMock().getClass());
        System.out.println(userEntity.getUuid());

        // stubbing 空方法的行为，该行为定义为 doNothing()
        doNothing().when(userEntity).throwException();
        userEntity.throwException();

        // stubbing 空方法的行为，该行为定义为 doThrow()
        doThrow(IllegalArgumentException.class).when(userEntity).throwException();
        userEntity.throwException();
    }
}
