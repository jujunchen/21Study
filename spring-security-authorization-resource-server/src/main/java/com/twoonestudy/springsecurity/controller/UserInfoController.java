package com.twoonestudy.springsecurity.controller;

import com.twoonestudy.springsecurity.res.UserInfoRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @GetMapping("/userinfo")
    public UserInfoRes getUserInfo() {
        UserInfoRes userInfoRes = new UserInfoRes();
        userInfoRes.setUsername("阿提说说");
        return userInfoRes;
    }
}
