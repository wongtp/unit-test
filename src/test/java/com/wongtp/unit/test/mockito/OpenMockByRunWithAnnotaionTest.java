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

import static org.mockito.Mockito.when;

/**
 * 使用 Junit 的 @RunWith() + MockitoJUnitRunner 来让当前的类支持 Mocktio
 * @author wongtp
 * @date 2024-06-21
 */
@RunWith(MockitoJUnitRunner.class)
public class OpenMockByRunWithAnnotaionTest {

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
