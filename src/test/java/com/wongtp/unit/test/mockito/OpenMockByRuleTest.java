/*
 * Copyleft
 */
package com.wongtp.unit.test.mockito;

import com.wongtp.unit.test.app.entity.UserEntity;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

/**
 * 使用 Junit 的 @Rule 注解来让当前的类支持 Mocktio
 * @author wongtp
 * @date 2024-06-21
 */
public class OpenMockByRuleTest {

    /**
     * 使用 @Rule 来让当前这个类支持 @Mock, @Spy, @Captor, @InjectMocks 等 Mockito 的注解
     */
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * 使用 @Mock 注解来 mock 对象，需要和 @Rule、@RunWith 注解配套使用
     */
    @Mock
    public UserEntity userEntity;

    @Test
    public void test() {
        when(userEntity.getId()).thenReturn(111);
        Assert.assertEquals(userEntity.getId(), Integer.valueOf(111));
    }
}
