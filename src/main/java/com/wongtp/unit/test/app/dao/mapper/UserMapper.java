/*
 * Copyleft
 */
package com.wongtp.unit.test.app.dao.mapper;

import com.wongtp.unit.test.app.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wongtp
 * @date 2024-06-21
 */
@Mapper
public interface UserMapper {

    @Select("select count(*) from unt_user")
    int countUser();

    @Insert("insert into unt_user(phone, username, uuid) values(#{user.phone}, #{user.username}, #{user.uuid})")
    boolean insertUser(@Param("user") UserEntity userEntity);

    @Select("select * from unt_user where phone = #{phone}")
    UserEntity findUserByPhone(@Param("phone") String phone);
}
