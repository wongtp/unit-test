/*
 * Copyleft
 */
package com.wongtp.unit.test.mockito;

import com.wongtp.unit.test.app.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * 用于除了 Assert 之外的其他验证结果的方式
 * @author wongtp
 * @date 2024-06-21
 */
@RunWith(MockitoJUnitRunner.class)
public class VerifyTest {

    @Mock
    public UserEntity userEntity;

    @Test
    public void verifyTest() {
        userEntity.setId(1);
        // 验证 setId 方法被调用过，且参数只能 1
        verify(userEntity).setId(1);

        userEntity.setId(2);
        // 验证 setId 方法被调用过的次数，且参数可以是任何 int 值，
        // 例如 anyInt() 都有更多相似写法，例如 anyString()，可参考 ArgumentMatchers
        // 例如 times(2) 都有更多验证类型，可参考 VerificationMode 接口，相关实现都在 ArgumentMatchers 中
        verify(userEntity, times(2)).setId(anyInt());

        // 验证对象中方法的调用顺序
        InOrder order = inOrder(userEntity);
        order.verify(userEntity).setId(1);
        order.verify(userEntity).setId(anyInt());

        // 使用 hamcrest 的自述性写法来校验
        assertThat(userEntity.getId(), equalTo(0));
    }
}
