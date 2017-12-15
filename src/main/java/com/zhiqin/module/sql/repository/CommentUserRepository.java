package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.CommentUserVo;
import com.zhiqin.module.sql.entity.MessageVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface CommentUserRepository extends JpaRepository<CommentUserVo, Integer>, JpaSpecificationExecutor<CommentUserVo> {
    List<CommentUserVo>  findAllByMsgId(int msgId);
}
