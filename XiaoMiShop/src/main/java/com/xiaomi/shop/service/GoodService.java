package com.xiaomi.shop.service;

import com.xiaomi.shop.entity.Good;

import java.util.List;

public interface GoodService {

    public List<Good> selectAll();

    public Boolean insert(String title, String src,double price, String desc, double old_price);

    public Boolean update(int id, String title, String src, double price, String desc, double old_price);

    public Boolean delete(int id);

}
