package com.xiaomi.shop.controller;

import com.xiaomi.shop.service.DropdownService;
import com.xiaomi.shop.utils.ResultMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DropdownController {

    @Autowired
    DropdownService dropdownService;

    @Autowired
    ResultMap resultMap;

    @ApiOperation(value = "通过sid获取下拉列表")
    @GetMapping("/dropdownBySid")
    public Object getDropdownBySid(int sid) {
        return resultMap.success().code(200).data(dropdownService.selectBySid(sid));
    }

    @ApiOperation(value = "获取下拉列表")
    @GetMapping("/dropdowns")
    public Object getDropdowns() {
        return resultMap.success().code(200).data(dropdownService.selectAll());
    }

    @ApiOperation(value = "添加下拉")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "顶栏id", dataType = "int"),
            @ApiImplicitParam(name = "gid", value = "商品id", dataType = "int")
    })
    @PostMapping("/dropdown")
    public Object addDropdown(int sid, int gid) {
        if (dropdownService.insert(sid, gid)) {
            return resultMap.success().code(201).message("添加成功");
        } else {
            return resultMap.fail().code(401).message("添加失败");
        }
    }

    @ApiOperation(value = "通过id删除下拉")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "下拉id", dataType = "int")
    })
    @DeleteMapping("/dropdown")
    public Object deleteDropdown(int id){
        if (dropdownService.delete(id)) {
            return resultMap.success().code(201).message("删除成功");
        } else {
            return resultMap.fail().code(401).message("删除失败");
        }
    }

    @ApiOperation(value = "编辑下拉")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "下拉id", dataType = "int"),
            @ApiImplicitParam(name = "sid", value = "顶栏id", dataType = "int"),
            @ApiImplicitParam(name = "gid", value = "商品id", dataType = "int"),
    })
    @PutMapping("/dropdown")
    public Object editDropdown(int id, int sid, int gid){
        if (dropdownService.update(id, sid, gid)) {
            return resultMap.success().code(201).message("编辑成功");
        } else {
            return resultMap.fail().code(401).message("编辑失败");
        }
    }

}
