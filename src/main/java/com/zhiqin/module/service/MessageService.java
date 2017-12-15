package com.zhiqin.module.service;

import com.zhiqin.module.dto.CommentUserVoDTO;
import com.zhiqin.module.dto.MessageVoDTO;
import com.zhiqin.module.sql.entity.CommentUserVo;
import com.zhiqin.module.sql.entity.MessageVo;
import com.zhiqin.module.sql.entity.UserInfo;
import com.zhiqin.module.sql.repository.CommentUserRepository;
import com.zhiqin.module.sql.repository.CommentVoRepository;
import com.zhiqin.module.sql.repository.MessageRepository;
import com.zhiqin.module.sql.repository.UserInfoRepository;
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
            messageVoDTOList.add(voDTO);
        }
        return RespBaseUtils.setResult(messageVoDTOList);
    }


}
