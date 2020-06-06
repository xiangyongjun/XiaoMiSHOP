package com.xiaomi.shop.mapper;

import com.xiaomi.shop.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    public List<User> selectAll();

    @Select("SELECT * FROM user WHERE username='${username}' AND password='${password}'")
    public User findOne(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO user(`username`,`password`,`nickname`) VALUES('${username}','${password}','${nickname}')")
    public Boolean insert(@Param("username") String username, @Param("password") String password, @Param("nickname") String nickname);

    @Update("UPDATE user SET password='${password}',nickname='${nickname}' WHERE id=${id}")
    public Boolean update(@Param("id") int id, @Param("password") String password, @Param("nickname") String nickname);

    @Delete("DELETE FROM user WHERE id=${id}")
    public Boolean delete(@Param("id") int id);

}
