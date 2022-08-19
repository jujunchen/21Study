package com.twoonestudy.springsecurity;

import com.twoonestudy.springsecurity.res.Result;
import com.twoonestudy.springsecurity.res.UserInfoRes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @GetMapping("/userinfo")
    public Result getUserInfo() {
        UserInfoRes userInfoRes = new UserInfoRes();
        userInfoRes.setUsername("阿提说说");
        return Result.ok(userInfoRes);
    }
}
