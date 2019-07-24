package com.cmlx.reactor.controller;

import com.cmlx.reactor.dto.User;
import com.cmlx.reactor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cmlx
 * @Date 2019-7-24 0024 14:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("getUserInfo")
    public User getUserInfo(){
        return userService.getUserInfo();
    }



}
