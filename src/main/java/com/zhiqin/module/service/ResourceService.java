package com.zhiqin.module.service;

import com.zhiqin.module.dto.CommentVoDTO;
import com.zhiqin.module.dto.QualityInfoDTO;
import com.zhiqin.module.dto.ResourcesInfoDTO;
import com.zhiqin.module.dto.TagResourcesDTO;
import com.zhiqin.module.sql.entity.*;
import com.zhiqin.module.sql.repository.*;
import com.zhiqin.module.utils.BeanCopyUtils;
import com.zhiqin.module.utils.PageQuery;
import com.zhiqin.module.utils.RespBase;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by maple on 2017/12/6.
 */
@Service
public class ResourceService {
    @Autowired
    private QualityInfoRepository qualityInfoRepository;
    @Autowired
    private ResourcesInfoRepository resourcesInfoRepository;
    @Autowired
    private TagResourceRepository tagResourceRepository;
    @Autowired
    private CommentVoRepository commentVoRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @PersistenceContext
    private EntityManager em;

    /**
     * 获取基础分类下的所有资源视频
     *
     * @param tagResourcesDTO
     * @return
     */
    public RespBase<List<ResourcesInfoDTO>> findByTagId(TagResourcesDTO tagResourcesDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        RespBase<List<ResourcesInfoDTO>> respBase = new RespBase<>();
        int pageIndex = tagResourcesDTO.getPageIndex();
        int pageSize = tagResourcesDTO.getPageSize();
        if (pageIndex < 1) {
            System.out.println("page参数错误，不能小于1");
            return null;
        }
        if (pageSize < 1) {
            System.out.println("size参数错误，不能小于1");
            return null;
        }
        //page设置
        pageIndex = pageIndex - 1;
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<TagResources> pageTr = tagResourceRepository.findAllByTagIdAndTagParentId(tagResourcesDTO.getTagId(), tagResourcesDTO.getTagParentId(), pageable);
        List<TagResources> listTr = pageTr.getContent();
        List<ResourcesInfoDTO> list = new ArrayList<>();
        for (TagResources tagResources : listTr) {
            ResourcesInfoDTO resourcesInfoDTO = new ResourcesInfoDTO();
            ResourcesInfo resourcesInfo = resourcesInfoRepository.findOne(tagResources.getResourcesId());
            BeanCopyUtils.copyProperties(resourcesInfo, resourcesInfoDTO);
            List<CommentVo> listComment = new ArrayList<>();
            if (Objects.nonNull(resourcesInfo)) {
                listComment = commentVoRepository.findAllByResourceId(resourcesInfo.getId());
            }
            List<CommentVoDTO> commentVoDTOList = new ArrayList<>();
            if (listComment.size() > 0) {
                for (CommentVo commentVo : listComment) {
                    CommentVoDTO commentVoDTO = new CommentVoDTO();
                    BeanCopyUtils.copyProperties(commentVo, commentVoDTO);
                    if (Objects.nonNull(commentVoDTO.getCreateTime())) {
                        commentVoDTO.setCreateTimeStr(sdf.format(commentVoDTO.getCreateTime()));
                    }
                    commentVoDTOList.add(commentVoDTO);
                }
                resourcesInfoDTO.setListCommentVoDTO(commentVoDTOList);
            }
            list.add(resourcesInfoDTO);
        }
        respBase.setResult(list);
        return respBase;
    }

    /**
     * 获取素质教育下分类的资源
     */
    public RespBase<List<QualityInfoDTO>> findByType(QualityInfoDTO qualityInfoDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        RespBase<List<QualityInfoDTO>> respBase = new RespBase<>();
        int pageIndex = qualityInfoDTO.getPageIndex();
        int pageSize = qualityInfoDTO.getPageSize();
        if (pageIndex < 1) {
            System.out.println("page参数错误，不能小于1");
            return null;
        }
        if (pageSize < 1) {
            System.out.println("size参数错误，不能小于1");
            return null;
        }
        //page设置
        pageIndex = pageIndex - 1;
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<QualityInfo> pageList = qualityInfoRepository.findAllByType(qualityInfoDTO.getType(), pageable);
        List<QualityInfo> list = pageList.getContent();
        List<QualityInfoDTO> qualityInfoDTOList = new ArrayList<>();
        for (QualityInfo vo : list) {
            QualityInfoDTO voDTO = new QualityInfoDTO();
            BeanCopyUtils.copyProperties(vo, voDTO);
            List<CommentVo> listComment = new ArrayList<>();
            listComment = commentVoRepository.findAllByResourceId(vo.getId());
            List<CommentVoDTO> commentVoDTOList = new ArrayList<>();
            if (listComment.size() > 0) {
                for (CommentVo commentVo : listComment) {
                    CommentVoDTO commentVoDTO = new CommentVoDTO();
                    BeanCopyUtils.copyProperties(commentVo, commentVoDTO);
                    if (Objects.nonNull(commentVoDTO.getCreateTime())) {
                        commentVoDTO.setCreateTimeStr(sdf.format(commentVoDTO.getCreateTime()));
                    }
                    commentVoDTOList.add(commentVoDTO);
                }
                voDTO.setListCommentVoDTO(commentVoDTOList);
            }
            qualityInfoDTOList.add(voDTO);
        }
        respBase.setResult(qualityInfoDTOList);
        return respBase;
    }

    /**
     * 发表评论
     */
    public RespBase<String> addComment(CommentVoDTO commentVoDTO) {
        RespBase<String> respBase = new RespBase<>();
        CommentVo vo = new CommentVo();
        BeanCopyUtils.copyProperties(commentVoDTO, vo);
        UserInfo userInfo = userInfoRepository.findOne(commentVoDTO.getUserId());
        if (Objects.isNull(userInfo)) {
            throw new RuntimeException("没有找到对应用户！");
        }
        vo.setUserName(userInfo.getNickName());
        vo.setCreateTime(new Date());
        commentVoRepository.save(vo);
        respBase.setResult("success");
        return respBase;
    }


    /**
     * 查找所有评论
     */
    public RespBase<List<CommentVoDTO>> findComment(CommentVoDTO commentVoDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        RespBase<List<CommentVoDTO>> respBase = new RespBase<>();
        List<CommentVo> list = commentVoRepository.findAllByResourceId(commentVoDTO.getResourceId());
        List<CommentVoDTO> commentVoDTOList = new ArrayList<>();
        for (CommentVo vo : list) {
            commentVoDTO = new CommentVoDTO();
            BeanCopyUtils.copyProperties(vo, commentVoDTO);
            if (Objects.nonNull(commentVoDTO.getCreateTime())) {
                commentVoDTO.setCreateTimeStr(sdf.format(commentVoDTO.getCreateTime()));
            }
            commentVoDTOList.add(commentVoDTO);
        }
        respBase.setResult(commentVoDTOList);
        return respBase;
    }


    /**
     * 获取基础分类下的所有资源视频
     *
     * @param tagResourcesDTO
     * @return
     */
    public RespBase<List<ResourcesInfoDTO>> findAllResorceBycodeId(TagResourcesDTO tagResourcesDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        RespBase<List<ResourcesInfoDTO>> respBase = new RespBase<>();
        StringBuffer sql = new StringBuffer("select r.* from tag  t LEFT JOIN tag_resources  r ON t.id=r.TAG_ID where t.id=r.TAG_ID and t.tag_parent_id=r.TAG_PARENT_ID   and t.CODE_ID=" + tagResourcesDTO.getCodeId() + "");
        Query query = this.em.createNativeQuery(sql.toString());
        //查询到的结果转成map类型
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        //分页查询 默认为index为1和size为8
        PageQuery pageQuery = new PageQuery(Objects.nonNull(tagResourcesDTO.getPageIndex()) ? tagResourcesDTO.getPageIndex() : 1, Objects.nonNull(tagResourcesDTO.getPageSize()) ? tagResourcesDTO.getPageSize() : 10, query);
//        List<TagResources> listTr = tagResourceRepository.findAllByCodeId(tagResourcesDTO.getCodeId());
        List<ResourcesInfoDTO> list = new ArrayList<>();
        for (int i = 0; i < pageQuery.getResult().size(); i++) {
            Map map = (Map) pageQuery.getResult().get(i);
            ResourcesInfoDTO resourcesInfoDTO = new ResourcesInfoDTO();
            ResourcesInfo resourcesInfo = resourcesInfoRepository.findOne(Integer.valueOf(map.get("RESOURCES_ID").toString()));
            BeanCopyUtils.copyProperties(resourcesInfo, resourcesInfoDTO);
            List<CommentVo> listComment = new ArrayList<>();
            if (Objects.nonNull(resourcesInfo)) {
                listComment = commentVoRepository.findAllByResourceId(resourcesInfo.getId());
            }
            List<CommentVoDTO> commentVoDTOList = new ArrayList<>();
            if (listComment.size() > 0) {
                for (CommentVo commentVo : listComment) {
                    CommentVoDTO commentVoDTO = new CommentVoDTO();
                    BeanCopyUtils.copyProperties(commentVo, commentVoDTO);
                    if (Objects.nonNull(commentVoDTO.getCreateTime())) {
                        commentVoDTO.setCreateTimeStr(sdf.format(commentVoDTO.getCreateTime()));
                    }
                    commentVoDTOList.add(commentVoDTO);
                }
                resourcesInfoDTO.setListCommentVoDTO(commentVoDTOList);
            }
            list.add(resourcesInfoDTO);
        }
        respBase.setResult(list);
        return respBase;
    }

    /**
     * 获取基础分类下的所有资源视频
     *
     * @param tagResourcesDTO
     * @return
     */
    public RespBase<List<ResourcesInfoDTO>> listAllresource(TagResourcesDTO tagResourcesDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        RespBase<List<ResourcesInfoDTO>> respBase = new RespBase<>();
        int pageIndex = tagResourcesDTO.getPageIndex();
        int pageSize = tagResourcesDTO.getPageSize();
        if (pageIndex < 1) {
            System.out.println("page参数错误，不能小于1");
            return null;
        }
        if (pageSize < 1) {
            System.out.println("size参数错误，不能小于1");
            return null;
        }
        //page设置
        pageIndex = pageIndex - 1;
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<ResourcesInfo> pageTr = resourcesInfoRepository.findAll(pageable);
        List<ResourcesInfo> listTr = pageTr.getContent();
        List<ResourcesInfoDTO> list = new ArrayList<>();
        for (ResourcesInfo resourcesInfo : listTr) {
            ResourcesInfoDTO resourcesInfoDTO = new ResourcesInfoDTO();
            BeanCopyUtils.copyProperties(resourcesInfo, resourcesInfoDTO);
            List<CommentVo> listComment = new ArrayList<>();
            if (Objects.nonNull(resourcesInfo)) {
                listComment = commentVoRepository.findAllByResourceId(resourcesInfo.getId());
            }
            List<CommentVoDTO> commentVoDTOList = new ArrayList<>();
            if (listComment.size() > 0) {
                for (CommentVo commentVo : listComment) {
                    CommentVoDTO commentVoDTO = new CommentVoDTO();
                    BeanCopyUtils.copyProperties(commentVo, commentVoDTO);
                    if (Objects.nonNull(commentVoDTO.getCreateTime())) {
                        commentVoDTO.setCreateTimeStr(sdf.format(commentVoDTO.getCreateTime()));
                    }
                    commentVoDTOList.add(commentVoDTO);
                }
                resourcesInfoDTO.setListCommentVoDTO(commentVoDTOList);
            }
            list.add(resourcesInfoDTO);
        }
        respBase.setResult(list);
        return respBase;
    }


}
