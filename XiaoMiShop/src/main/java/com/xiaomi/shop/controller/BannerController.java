package com.xiaomi.shop.controller;

import com.xiaomi.shop.service.BannerService;
import com.xiaomi.shop.utils.ResultMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @Autowired
    ResultMap resultMap;

    @ApiOperation(value = "获取轮播图列表")
    @GetMapping("/banners")
    public Object getBanners() {
        return resultMap.success().code(200).data(bannerService.selectAll());
    }

    @ApiOperation(value = "添加轮播图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "src", value = "图片地址", dataType = "String"),
            @ApiImplicitParam(name = "link", value = "链接地址", dataType = "String")
    })
    @PostMapping("/banner")
    public Object addBanner(String src, String link) {
        if (bannerService.insert(src, link)) {
            return resultMap.success().code(201).message("轮播图添加成功");
        } else {
            return resultMap.fail().code(401).message("轮播图添加失败");
        }
    }

    @ApiOperation(value = "通过id删除轮播图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "轮播图id", dataType = "int")
    })
    @DeleteMapping("/banner")
    public Object deleteBanner(int id){
        if (bannerService.delete(id)) {
            return resultMap.success().code(201).message("删除成功");
        } else {
            return resultMap.fail().code(401).message("删除失败");
        }
    }

    @ApiOperation(value = "编辑轮播图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int"),
            @ApiImplicitParam(name = "src", value = "图片地址", dataType = "String"),
            @ApiImplicitParam(name = "link", value = "链接", dataType = "String")
    })
    @PutMapping("/banner")
    public Object editBanner(int id, String src, String link){
        if (bannerService.update(id, src, link)) {
            return resultMap.success().code(201).message("编辑成功");
        } else {
            return resultMap.fail().code(401).message("编辑失败");
        }
    }

}
