package com.xiaomi.shop.service;

import com.xiaomi.shop.entity.User;

import java.util.List;

public interface UserService {

    public List<User> selectAll();

    public User findOne(String username, String password);

    public Boolean insert( String username, String password, String nickname);

    public Boolean update(int id, String password,String nickname);

    public Boolean delete(int id);

}
