/*
 * Copyleft
 */
package com.wongtp.unit.test.mariadb4j;

import com.wongtp.unit.test.app.dao.UserDao;
import com.wongtp.unit.test.app.entity.UserEntity;
import com.wongtp.unit.test.framework.core.AbstractMariaDb4jSpringTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wongtp
 * @date 2024-05-16
 */
public class MariaDb4jUserDaoTest extends AbstractMariaDb4jSpringTest {

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
        userEntity.setUsername("test_username");
        userEntity.setUuid(UUID.randomUUID().toString());
        boolean added = userDao.addUser(userEntity);
        Assertions.assertTrue(added);

        UserEntity databaseUser = userDao.findUserByPhone(userEntity.getPhone());
        Assertions.assertNotNull(databaseUser);
        Assertions.assertEquals(userEntity.getUuid(), databaseUser.getUuid());
    }

    @Test
    public void should_save_user_error() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone("13800000001");
        userEntity.setUuid(UUID.randomUUID() + "-- too long for column error");
        userEntity.setUsername("test_username");
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userDao.addUser(userEntity));
    }
}
