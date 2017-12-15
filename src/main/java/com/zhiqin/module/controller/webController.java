package com.zhiqin.module.controller;

import com.zhiqin.module.utils.RespBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lyf
 */
@RestController
@RequestMapping("/web")
public class webController {

    @RequestMapping("/error")
    public RespBase<String> error() {
        RespBase<String> respWebBase = new RespBase<>();
        respWebBase.setErrorMsg("服务器内部错误！");
        respWebBase.setErrorCode(-1);
        return respWebBase;
    }
}
