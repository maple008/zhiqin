package com.zhiqin.module.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhiqin.module.dto.CommentUserVoDTO;
import com.zhiqin.module.dto.MessageVoDTO;
import com.zhiqin.module.service.MessageService;
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
 * Created by maple on 2017/12/15.
 */
@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private FileLoad fileLoad;

    /**
     * 添加MSG
     *
     * @return
     */
    @PostMapping("/addMessage")
    public RespBase<String> addMessage(MessageVoDTO messageVoDTO, @RequestParam(value = "img", required = false) MultipartFile[] file) {
        List list = new ArrayList();
        if (file.length>0&&file[0].getSize() > 0) {
            list = fileLoad.getImgFile(file, "customer");
        }
        JSONObject jsonObject = new JSONObject();
        if (list.size() == 1) {
            jsonObject.put("path", list.get(0).toString());
        } else if (list.size() > 1) {
            jsonObject.put("path", list);
        }
        if (jsonObject.size() > 0) {
            messageVoDTO.setPhoto(jsonObject.getString("path"));
        }
        return messageService.addMessage(messageVoDTO);
    }

    /**
     * 添加评论
     *
     * @return
     */
    @PostMapping("/addCommentUser")
    public RespBase<String> addCommentUser(@RequestBody CommentUserVoDTO vo) {
        return messageService.addCommentUser(vo);
    }


    /**
     * 查询朋友圈
     *
     * @return
     */
    @PostMapping("/ListMessage")
    public RespBase<List<MessageVoDTO>> ListMessage(@RequestBody MessageVoDTO vo) {
        return messageService.ListMessage(vo);
    }


}
