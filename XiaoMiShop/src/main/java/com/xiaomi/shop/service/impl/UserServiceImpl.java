package com.xiaomi.shop.service.impl;

import com.xiaomi.shop.entity.User;
import com.xiaomi.shop.mapper.UserMapper;
import com.xiaomi.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findOne(String username, String password) {
        return userMapper.findOne(username, password);
    }

    @Override
    public Boolean insert(String username, String password, String nickname) {
        try {
            userMapper.insert(username, password, nickname);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Boolean update(int id, String password, String nickname) {
        try {
            userMapper.update(id, password, nickname);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(int id) {
        try {
            userMapper.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
