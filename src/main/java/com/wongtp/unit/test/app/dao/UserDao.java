/*
 * Copyleft
 */
package com.wongtp.unit.test.app.dao;

import com.wongtp.unit.test.app.dao.mapper.UserMapper;
import com.wongtp.unit.test.app.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Repository
public class UserDao {

    @Resource
    private UserMapper mapper;

    public int countUser() {
        return mapper.countUser();
    }

    public boolean addUser(UserEntity userEntity) {
        return mapper.insertUser(userEntity);
    }

    public UserEntity findUserByPhone(String phone) {
        return mapper.findUserByPhone(phone);
    }
}
