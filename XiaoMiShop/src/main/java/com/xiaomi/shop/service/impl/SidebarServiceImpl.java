package com.xiaomi.shop.service.impl;

import com.xiaomi.shop.entity.Sidebar;
import com.xiaomi.shop.mapper.SidebarMapper;
import com.xiaomi.shop.service.SidebarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SidebarServiceImpl implements SidebarService {

    @Resource
    SidebarMapper sidebarMapper;

    @Override
    public List<Sidebar> selectAll() {
        return sidebarMapper.selectAll();
    }

    @Override
    public Boolean insert(String title, String link) {
        return sidebarMapper.insert(title, link);
    }

    @Override
    public Boolean update(int id, String title, String link) {
        return sidebarMapper.update(id, title, link);
    }

    @Override
    public Boolean delete(int id) {
        return sidebarMapper.delete(id);
    }

}
