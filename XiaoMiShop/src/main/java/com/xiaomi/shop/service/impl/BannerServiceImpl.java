package com.xiaomi.shop.service.impl;

import com.xiaomi.shop.entity.Banner;
import com.xiaomi.shop.mapper.BannerMapper;
import com.xiaomi.shop.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }

    @Override
    public Boolean insert(String src, String link) {
        return bannerMapper.insert(src, link);
    }

    @Override
    public Boolean update(int id, String src, String link) {
        return bannerMapper.update(id, src, link);
    }

    @Override
    public Boolean delete(int id) {
        return bannerMapper.delete(id);
    }

}
