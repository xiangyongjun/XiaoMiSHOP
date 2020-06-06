package com.xiaomi.shop.controller;

import com.xiaomi.shop.service.SidebarService;
import com.xiaomi.shop.utils.ResultMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SidebarController {

    @Autowired
    SidebarService sidebarService;

    @Autowired
    ResultMap resultMap;

    @ApiOperation(value = "获取顶栏列表")
    @GetMapping("/sidebars")
    public Object getSidebars() {
        return resultMap.success().code(200).data(sidebarService.selectAll());
    }

    @ApiOperation(value = "添加顶栏标题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String"),
            @ApiImplicitParam(name = "link", value = "链接地址", dataType = "String")
    })
    @PostMapping("/sidebar")
    public Object addSidebar(String title, String link) {
        if (sidebarService.insert(title, link)) {
            return resultMap.success().code(201).message("顶栏添加成功");
        } else {
            return resultMap.fail().code(401).message("顶栏添加失败");
        }
    }

    @ApiOperation(value = "通过id删除顶栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "顶栏id", dataType = "int")
    })
    @DeleteMapping("/sidebar")
    public Object deleteSidebar(int id){
        if (sidebarService.delete(id)) {
            return resultMap.success().code(201).message("删除成功");
        } else {
            return resultMap.fail().code(401).message("删除失败");
        }
    }

    @ApiOperation(value = "编辑顶栏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int"),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String"),
            @ApiImplicitParam(name = "link", value = "链接", dataType = "String"),
    })
    @PutMapping("/sidebar")
    public Object editSidebar(int id, String title, String link){
        if (sidebarService.update(id, title, link)) {
            return resultMap.success().code(201).message("编辑成功");
        } else {
            return resultMap.fail().code(401).message("编辑失败");
        }
    }

}
