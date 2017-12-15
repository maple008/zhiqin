package com.zhiqin.module.controller;

import com.zhiqin.module.dto.*;
import com.zhiqin.module.service.DictionayService;
import com.zhiqin.module.service.ResourceService;
import com.zhiqin.module.sql.entity.CommentVo;
import com.zhiqin.module.utils.RespBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by maple on 2017/11/24.
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    /**
     * 获取基础分类下的所有资源视频
     *
     * @param tagResourcesDTO
     * @return
     */
    @PostMapping("/findByTagId")
    public RespBase<List<ResourcesInfoDTO>> findByTagId(@RequestBody TagResourcesDTO tagResourcesDTO) {
        return resourceService.findByTagId(tagResourcesDTO);
    }

    /**
     * 获取素质教育下分类的资源
     */
    @PostMapping("/findByType")
    public RespBase<List<QualityInfoDTO>> findByType(@RequestBody QualityInfoDTO qualityInfoDTO) {
        return resourceService.findByType(qualityInfoDTO);
    }

    /**
     * 发表评论
     */
    @PostMapping("/addComment")
    public RespBase<String> addComment(@RequestBody CommentVoDTO commentVoDTO) {
        return resourceService.addComment(commentVoDTO);
    }

    /**
     * 查看评论
     */
    @PostMapping("/findComment")
    public RespBase<List<CommentVoDTO>> findComment(@RequestBody CommentVoDTO commentVoDTO) {
        return resourceService.findComment(commentVoDTO);
    }


    /**
     * 获取基础分类下的所有资源视频根据CODE_ID
     *
     * @param tagResourcesDTO
     * @return
     */
    @PostMapping("/findAllResorceBycodeId")
    public RespBase<List<ResourcesInfoDTO>> findAllResorceBycodeId(@RequestBody TagResourcesDTO tagResourcesDTO) {
        return resourceService.findAllResorceBycodeId(tagResourcesDTO);
    }

    /**
     * 获取基础分类下的所有资源视频
     *
     * @param tagResourcesDTO
     * @return
     */
    @PostMapping("/listAllresource")
    public RespBase<List<ResourcesInfoDTO>> listAllresource(@RequestBody TagResourcesDTO tagResourcesDTO) {
        return resourceService.listAllresource(tagResourcesDTO);
    }

}
