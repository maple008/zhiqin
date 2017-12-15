package com.zhiqin.module.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhiqin.module.utils.FileLoad;
import com.zhiqin.module.utils.RespBase;
import com.zhiqin.module.utils.RespBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lyf
 */
@RestController
@RequestMapping("/web")
public class webController {
    @Autowired
    private FileLoad fileLoad;

    @RequestMapping("/error")
    public RespBase<String> error() {
        RespBase<String> respWebBase = new RespBase<>();
        respWebBase.setErrorMsg("服务器内部错误！");
        respWebBase.setErrorCode(-1);
        return respWebBase;
    }

    @PostMapping("/fileUploadApp")
    @ResponseBody
    public RespBase<JSONObject> fileUploadApp(Map<String, Object> model, @RequestParam(value = "img", required = false) MultipartFile[] file) {
        List list = new ArrayList();
        if (file[0].getSize() > 0) {
            list = fileLoad.getImgFile(file, "customer");
        }
        JSONObject jsonObject = new JSONObject();
        if (list.size() == 1) {
            jsonObject.put("path", list.get(0).toString());
        } else if (list.size() > 1) {
            jsonObject.put("path", list);
        }
        return RespBaseUtils.setResult(jsonObject);
    }
}
