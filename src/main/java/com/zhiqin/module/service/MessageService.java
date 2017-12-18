package com.zhiqin.module.service;

import com.zhiqin.module.dto.CommentUserVoDTO;
import com.zhiqin.module.dto.MessageVoDTO;
import com.zhiqin.module.dto.PraiseInfoDTO;
import com.zhiqin.module.sql.entity.CommentUserVo;
import com.zhiqin.module.sql.entity.MessageVo;
import com.zhiqin.module.sql.entity.PraiseInfo;
import com.zhiqin.module.sql.entity.UserInfo;
import com.zhiqin.module.sql.repository.*;
import com.zhiqin.module.utils.BeanCopyUtils;
import com.zhiqin.module.utils.PageModel;
import com.zhiqin.module.utils.RespBase;
import com.zhiqin.module.utils.RespBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by maple on 2017/12/15.
 */
@Service
public class MessageService {
    @Autowired
    private CommentUserRepository commentUserRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PraiseInfoRepository praiseInfoRepository;

    /**
     * 发表说说
     */
    public RespBase<String> addMessage(MessageVoDTO messageVoDTO) {
        RespBase<String> respBase = new RespBase<>();
        MessageVo vo = new MessageVo();
        BeanCopyUtils.copyProperties(messageVoDTO, vo);
        UserInfo userInfo = userInfoRepository.findOne(messageVoDTO.getUserId());
        if (Objects.isNull(userInfo)) {
            throw new RuntimeException("没有找到对应用户！");
        }
        vo.setUserName(userInfo.getNickName());
        vo.setCreateTime(new Date());
        messageRepository.save(vo);
        respBase.setResult("success");
        return respBase;
    }


    /**
     * 发表评论
     */
    public RespBase<String> addCommentUser(CommentUserVoDTO commentUserVoDTO) {
        RespBase<String> respBase = new RespBase<>();
        CommentUserVo vo = new CommentUserVo();
        List<CommentUserVo> commentUserVoList = commentUserRepository.findAllByUserIdAndMsgId(commentUserVoDTO.getUserId(), commentUserVoDTO.getMsgId());
        if (commentUserVoList.size() > 0) {
            throw new RuntimeException("请不要重复评论！");
        }
        BeanCopyUtils.copyProperties(commentUserVoDTO, vo);
        UserInfo userInfo = userInfoRepository.findOne(commentUserVoDTO.getUserId());
        if (Objects.isNull(userInfo)) {
            throw new RuntimeException("没有找到对应用户！");
        }
        vo.setUserName(userInfo.getNickName());
        vo.setCreateTime(new Date());
        commentUserRepository.save(vo);
        respBase.setResult("success");
        return respBase;
    }

    /**
     * 查询朋友圈
     */
    public RespBase<List<MessageVoDTO>> ListMessage(MessageVoDTO messageVoDTO) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        RespBase<List<MessageVoDTO>> respBase = new RespBase<>();
        int pageIndex = messageVoDTO.getPageIndex();
        int pageSize = messageVoDTO.getPageSize();
        if (pageIndex < 1) {
            return RespBaseUtils.setErrorResult("page参数错误，不能小于1");
        }
        if (pageSize < 1) {
            return RespBaseUtils.setErrorResult("ize参数错误，不能小于1");
        }
        //page设置
        pageIndex = pageIndex - 1;
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<MessageVo> pageList = messageRepository.findAll(pageable);
        List<MessageVo> list = pageList.getContent();
        List<MessageVoDTO> messageVoDTOList = new ArrayList<>();
        for (MessageVo vo : list) {
            MessageVoDTO voDTO = new MessageVoDTO();
            BeanCopyUtils.copyProperties(vo, voDTO);
            List<CommentUserVo> commentUserVoList = commentUserRepository.findAllByMsgId(voDTO.getId());
            List<PraiseInfo> praiseInfoList = praiseInfoRepository.findAllByMsgId(voDTO.getId());
            List<CommentUserVoDTO> commentUserVoDTOList = new ArrayList<>();
            for (CommentUserVo vo1 : commentUserVoList) {
                CommentUserVoDTO commentUserVoDTO = new CommentUserVoDTO();
                BeanCopyUtils.copyProperties(vo1, commentUserVoDTO);
                if (Objects.nonNull(commentUserVoDTO.getCreateTime())) {
                    commentUserVoDTO.setCreateTimeStr(sdf.format(commentUserVoDTO.getCreateTime()));
                }
                commentUserVoDTOList.add(commentUserVoDTO);
            }
            if (Objects.nonNull(voDTO.getCreateTime())) {
                voDTO.setCreateTimeStr(sdf.format(voDTO.getCreateTime()));
            }
            voDTO.setCommentUserVoDTOS(commentUserVoDTOList);
            voDTO.setPraiseNumber(praiseInfoList.size());
            voDTO.setCommentNumber(commentUserVoList.size());
            messageVoDTOList.add(voDTO);
        }
        return RespBaseUtils.setResult(messageVoDTOList);
    }


    /**
     * 点赞
     */
    public RespBase<String> addPraise(PraiseInfoDTO praiseInfoDTO) {
        RespBase<String> respBase = new RespBase<>();
        PraiseInfo vo = new PraiseInfo();
        BeanCopyUtils.copyProperties(praiseInfoDTO, vo);
        List<PraiseInfo> praiseInfoList = praiseInfoRepository.findAllByUserIdAndMsgId(praiseInfoDTO.getUserId(), praiseInfoDTO.getMsgId());
        if (praiseInfoList.size() > 0) {
            throw new RuntimeException("请不要重复点赞！");
        }
        UserInfo userInfo = userInfoRepository.findOne(praiseInfoDTO.getUserId());
        if (Objects.isNull(userInfo)) {
            throw new RuntimeException("没有找到对应用户！");
        }
        vo.setUserName(userInfo.getNickName());
        vo.setCreateTime(new Date());
        praiseInfoRepository.save(vo);
        respBase.setResult("success");
        return respBase;
    }

}
