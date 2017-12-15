package com.zhiqin.module.controller;

import com.zhiqin.module.dto.UserInfoDto;
import com.zhiqin.module.service.UserInfoService;
import com.zhiqin.module.sql.entity.UserInfo;
import com.zhiqin.module.utils.RespBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maple on 2017/11/24.
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MessageSource msgSource;

    /**
     * 注册
     *
     * @return
     */
    @PostMapping("/register")
    public RespBase<String> register(@Validated @RequestBody UserInfoDto userInfoDto) {
        return userInfoService.register(userInfoDto);
    }


    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    @PostMapping
    public RespBase<UserInfoDto> login(@Validated @RequestBody UserInfoDto userInfoDto) {
        return userInfoService.login(userInfoDto);
    }
}
