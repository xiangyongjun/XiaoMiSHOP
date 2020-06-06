package com.xiaomi.shop.service;

import com.xiaomi.shop.entity.Sidebar;

import java.util.List;

public interface SidebarService {

    public List<Sidebar> selectAll();

    public Boolean insert(String title, String link);

    public Boolean update(int id, String title, String link);

    public Boolean delete(int id);

}
