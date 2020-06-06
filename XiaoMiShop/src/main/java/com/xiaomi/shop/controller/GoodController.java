package com.xiaomi.shop.controller;

import com.xiaomi.shop.service.GoodService;
import com.xiaomi.shop.utils.ResultMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GoodController {

    @Autowired
    GoodService goodService;

    @Autowired
    ResultMap resultMap;

    @ApiOperation(value = "获取商品列表")
    @GetMapping("/goods")
    public Object getGoods() {
        return resultMap.success().code(200).data(goodService.selectAll());
    }

    @ApiOperation(value = "通过id删除商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", dataType = "int")
    })
    @DeleteMapping("/good")
    public Object deleteUser(int id){
        if (goodService.delete(id)) {
            return resultMap.success().code(201).message("删除成功");
        } else {
            return resultMap.fail().code(401).message("删除失败");
        }
    }

    @ApiOperation(value = "添加商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String"),
            @ApiImplicitParam(name = "src", value = "图片地址", dataType = "String"),
            @ApiImplicitParam(name = "price", value = "价格", dataType = "double"),
            @ApiImplicitParam(name = "desc", value = "介绍", dataType = "String"),
            @ApiImplicitParam(name = "old_price", value = "旧价格", dataType = "double"),
    })
    @PostMapping("/good")
    public Object addUser(String title, String src, double price, String desc, double old_price){
        if (goodService.insert(title, src, price, desc, old_price)) {
            return resultMap.success().code(201).message("添加成功");
        } else {
            return resultMap.fail().code(401).message("添加失败");
        }
    }

    @ApiOperation(value = "编辑商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", dataType = "int"),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String"),
            @ApiImplicitParam(name = "src", value = "图片地址", dataType = "String"),
            @ApiImplicitParam(name = "price", value = "价格", dataType = "double"),
            @ApiImplicitParam(name = "desc", value = "介绍", dataType = "String"),
            @ApiImplicitParam(name = "old_price", value = "旧价格", dataType = "double"),
    })
    @PutMapping("/good")
    public Object editUser(int id, String title, String src, double price, String desc, double old_price){
        if (goodService.update(id, title, src, price, desc, old_price)) {
            return resultMap.success().code(201).message("编辑成功");
        } else {
            return resultMap.fail().code(401).message("编辑失败");
        }
    }

}
