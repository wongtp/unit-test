/*
 * Copyleft
 */
package com.wongtp.unit.test.app.dao;

import com.wongtp.unit.test.app.entity.UserEntity;
import com.wongtp.unit.test.framework.core.AbstractDaoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wongtp
 * @date 2024-06-21
 */
public class UserDaoTest extends AbstractDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void should_count_user_success() {
        int userCount = userDao.countUser();
        Assertions.assertEquals(userCount, 0);
    }

    @Test
    public void should_save_user_success() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone("13800000000");
        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setUsername("test_username");
        boolean added = userDao.addUser(userEntity);
        Assertions.assertTrue(added);

        UserEntity databaseUser = userDao.findUserByPhone(userEntity.getPhone());
        Assertions.assertNotNull(databaseUser);
        Assertions.assertEquals(userEntity.getUuid(), databaseUser.getUuid());
    }

    @Test
    public void should_save_user_error() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(UUID.randomUUID() + "-- too long for column error");
        userEntity.setUsername("test_username");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userDao.addUser(userEntity));
    }
}