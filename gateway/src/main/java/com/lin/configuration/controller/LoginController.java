package com.lin.configuration.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.lin.LinResult;
import com.lin.configuration.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/login")
public class LoginController {
    @PostMapping
    public LinResult login(@RequestBody User user) {
        if ("admin".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            StpUtil.login(1);
            return LinResult.success().setMessage("登录成功").data("tokenInfo", StpUtil.getTokenValue());
        }
        return LinResult.error().setMessage("登录失败");
    }
}
