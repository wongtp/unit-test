/*
 * Copyleft
 */
package com.wongtp.unit.test.app.service;

import cn.hutool.http.HttpUtil;
import com.wongtp.unit.test.app.dao.UserDao;
import com.wongtp.unit.test.app.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Service
public class UserService {

    public static final String APPLY_TOKEN_URL = "/apply/token";

    private String tokenServerHost;

    @Resource
    private UserDao userDao;

    public boolean addUser(UserEntity userEntity) {
        return userDao.addUser(userEntity);
    }

    public String applyToken() {
        return HttpUtil.get(tokenServerHost + APPLY_TOKEN_URL);
    }

    @Value("${tokenServerHost:10.0.0.0:8080}")
    public void setTokenServerHost(String tokenServerHost) {
        this.tokenServerHost = tokenServerHost;
    }

}
