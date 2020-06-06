package com.xiaomi.shop.controller;

import com.xiaomi.shop.entity.User;
import com.xiaomi.shop.service.UserService;
import com.xiaomi.shop.utils.ResultMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ResultMap resultMap;

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/users")
    public Object getUsers(){
        return resultMap.success().code(200).data(userService.selectAll());
    }

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    @GetMapping("/user")
    public Object getUser(String username, String password){
        User user = userService.findOne(username, password);
        if (user != null) {
            return resultMap.success().code(200).message("登录成功").data(user);
        } else {
            return resultMap.fail().code(400).message("登录失败");
        }
    }

    @ApiOperation(value = "通过id删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int")
    })
    @DeleteMapping("/user")
    public Object deleteUser(int id){
        if (userService.delete(id)) {
            return resultMap.success().code(201).message("删除成功");
        } else {
            return resultMap.fail().code(401).message("删除失败");
        }
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String"),
            @ApiImplicitParam(name = "nickname", value = "昵称", dataType = "String"),
    })
    @PostMapping("/user")
    public Object addUser(String username, String password, String nickname){
        if (userService.insert(username, password, nickname)) {
            return resultMap.success().code(201).message("添加成功");
        } else {
            return resultMap.fail().code(401).message("添加失败");
        }
    }

    @ApiOperation(value = "编辑用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String"),
            @ApiImplicitParam(name = "nickname", value = "昵称", dataType = "String")
    })
    @PutMapping("/user")
    public Object editUser(int id, String password, String nickname){
        if (userService.update(id, password, nickname)) {
            return resultMap.success().code(201).message("编辑成功");
        } else {
            return resultMap.fail().code(401).message("编辑失败");
        }
    }

}



