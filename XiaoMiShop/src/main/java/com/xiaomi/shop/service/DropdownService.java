package com.xiaomi.shop.service;

import com.xiaomi.shop.entity.Dropdown;

import java.util.List;

public interface DropdownService {

    public List<Dropdown> selectBySid(int sid);

    public List<Dropdown> selectAll();

    public Boolean insert(int sid, int gid);

    public Boolean update(int id, int sid, int gid);

    public Boolean delete(int id);

}
