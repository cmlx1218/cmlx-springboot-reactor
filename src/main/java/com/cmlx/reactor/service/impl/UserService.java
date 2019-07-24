package com.cmlx.reactor.service.impl;

import com.cmlx.reactor.dto.User;
import com.cmlx.reactor.handler.UserHandler;
import com.cmlx.reactor.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cmlx
 * @Date 2019-7-24 0024 14:44
 * @Version 1.0
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserHandler userHandler;


    @Override
    public User getUserInfo() {

        userHandler.send(new User().setUserId(1314L).setUserName("赤名莉香").setAddress("东京").setHobby("强"));

        return new User().setUserId(1314L).setUserName("赤名莉香").setAddress("东京").setHobby("强");
    }



}
