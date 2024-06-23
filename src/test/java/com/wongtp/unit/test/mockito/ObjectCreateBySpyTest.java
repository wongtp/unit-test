/*
 * Copyleft
 */
package com.wongtp.unit.test.mockito;

import com.wongtp.unit.test.app.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.spy;

/**
 * 使用 spy 模式来创建测试对象 <br/>
 * spy 模式的应用场景是针对现有实例对象的部分行为进行定义，<br/>
 * spy 模式和 mock 模式正好相反，mock 是直接创建代理类，所有类行为都是代理类的行为，而 spy 的行为则是源于现有类实例或者类静态行为
 * @author wongtp
 * @date 2024-06-21
 */
@RunWith(MockitoJUnitRunner.class)
public class ObjectCreateBySpyTest {

    private final UserEntity userEntity = new UserEntity();

    /**
     * 使用注解的方式类创建测试对象
     */
    @Spy
    private UserEntity spyUserEntity;

    @Test
    public void spyTest() {
        userEntity.setId(999);
        Assert.assertNull(spyUserEntity.getId());

        userEntity.setId(111);
        // 使用 Mocktio.spy() 方法来创建测试对象
        spyUserEntity = spy(userEntity);
        Assert.assertEquals(spyUserEntity.getId(), Integer.valueOf(111));
    }
}
