package com.xiaomi.shop.service.impl;

import com.xiaomi.shop.entity.Good;
import com.xiaomi.shop.mapper.GoodMapper;
import com.xiaomi.shop.service.GoodService;
import com.xiaomi.shop.service.SidebarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Resource
    GoodMapper goodMapper;

    @Override
    public List<Good> selectAll() {
        return goodMapper.selectAll();
    }

    @Override
    public Boolean insert(String title, String src, double price, String desc, double old_price) {
        return goodMapper.insert(title, src, price, desc, old_price);
    }

    @Override
    public Boolean update(int id, String title, String src, double price, String desc, double old_price) {
        return goodMapper.update(id, title, src, price, desc, old_price);
    }

    @Override
    public Boolean delete(int id) {
        return goodMapper.delete(id);
    }

}
