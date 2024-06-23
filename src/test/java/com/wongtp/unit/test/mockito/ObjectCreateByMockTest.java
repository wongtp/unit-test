/*
 * Copyleft
 */
package com.wongtp.unit.test.mockito;

import com.wongtp.unit.test.app.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 使用 mock 模式来创建测试对象  <br/>
 * mock 模式用于创建一个全新的代理对象，所有行为和原来的对象都不一样，可以理解为创建的这个代理对象的所有方法都是空方法，方法内部没有任何动作
 * @author wongtp
 * @date 2024-06-21
 */
@RunWith(MockitoJUnitRunner.class)
public class ObjectCreateByMockTest {

    /**
     * 使用 mock() 方法直接 mock 对象，不需要依赖 @Rule、@Mock、@RunWith、@ExtendWith 等注解
     */
    private final UserEntity mockByStaticInvokeUserEntity = mock(UserEntity.class);

    /**
     * 使用 @Mock 注解来 mock 对象，需要和 @Rule、@RunWith 注解配套使用
     */
    @Mock
    public UserEntity mockByAnnotationUserEntity;

    @Test
    public void mockTest() {
        when(mockByStaticInvokeUserEntity.getId()).thenReturn(111);
        Assert.assertEquals(mockByStaticInvokeUserEntity.getId(), Integer.valueOf(111));

        when(mockByAnnotationUserEntity.getId()).thenReturn(111);
        Assert.assertEquals(mockByAnnotationUserEntity.getId(), Integer.valueOf(111));
    }
}
