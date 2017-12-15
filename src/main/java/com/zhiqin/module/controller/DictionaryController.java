package com.zhiqin.module.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhiqin.module.dto.DictionaryDto;
import com.zhiqin.module.service.DictionayService;
import com.zhiqin.module.utils.RespBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maple on 2017/11/24.
 */
@RestController
@RequestMapping("/type")
public class DictionaryController {
    @Autowired
    private DictionayService dictionayService;

    @GetMapping("/listDictionary")
    public RespBase<DictionaryDto> listDictionary() {
        return dictionayService.listDictionary();
    }

    @GetMapping("/findNextTag")
    public RespBase<List<DictionaryDto>> findNextTag(@RequestParam Integer id) {
        return dictionayService.findNextTag(id);
    }

    @GetMapping("/listAllType")
    public RespBase<JSONObject> listAllType() {
        return dictionayService.listAllType();
    }

    @GetMapping("/findNextByCodeId")
    public RespBase<List<DictionaryDto>> findNextByCodeId(@RequestParam Integer id) {
        return dictionayService.findNextByCodeId(id);
    }
}
