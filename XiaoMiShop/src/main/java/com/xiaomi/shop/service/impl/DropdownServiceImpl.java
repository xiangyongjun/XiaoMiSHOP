package com.xiaomi.shop.service.impl;

import com.xiaomi.shop.entity.Dropdown;
import com.xiaomi.shop.mapper.DropdownMapper;
import com.xiaomi.shop.service.DropdownService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DropdownServiceImpl implements DropdownService {

    @Resource
    DropdownMapper dropdownMapper;

    @Override
    public List<Dropdown> selectBySid(int sid) {
        return dropdownMapper.selectBySid(sid);
    }

    @Override
    public List<Dropdown> selectAll() {
        return dropdownMapper.selectAll();
    }

    @Override
    public Boolean insert(int sid, int gid) {
        return dropdownMapper.insert(sid, gid);
    }

    @Override
    public Boolean update(int id, int sid, int gid) {
        return dropdownMapper.update(id, sid, gid);
    }

    @Override
    public Boolean delete(int id) {
        return dropdownMapper.delete(id);
    }

}
