package com.xiaomi.shop.service;

import com.xiaomi.shop.entity.Banner;

import java.util.List;

public interface BannerService {

    public List<Banner> selectAll();

    public Boolean insert(String src, String link);

    public Boolean update(int id, String src, String link);

    public Boolean delete(int id);

}
