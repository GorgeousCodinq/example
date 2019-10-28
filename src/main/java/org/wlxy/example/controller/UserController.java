package org.wlxy.example.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wlxy.example.common.HttpCode;
import org.wlxy.example.common.MyException;
import org.wlxy.example.common.MyRsp;
import org.wlxy.example.common.PageParam;
import org.wlxy.example.model.User;
import org.wlxy.example.service.UserService;

import javax.validation.Valid;
@Api(value = "user模块接口",description = "这是一个用户模块的接口文档")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/getAllUser")
    public Object getAllUser(@RequestBody PageParam<User> pageParam){//    @RequestBody(required = false)


        return MyRsp.success(userService.getAllUser(pageParam));
    }

    @GetMapping("/removeUserById/{id}")
    public Object removeUserByUserName(@PathVariable("id") int id){

        return userService.removeUserById(id)?MyRsp.success(null):MyRsp.error().msg("删除失败");
    }
    @PostMapping("/addUser")
    public Object addUser(@RequestBody @Valid User user){
        User u=(User)userService.addUser(user);

        return u!=null?MyRsp.success(u).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateUser")
    public Object updateUser(@RequestBody@Valid User user){

        return userService.updateUser(user)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getUserById/{id}")
    public Object getUserById(@PathVariable("id") int id){

        User user=userService.getUserById(id);
        return user!=null?MyRsp.success(user):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }



}
