package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.CommentVo;
import com.zhiqin.module.sql.entity.MessageVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface MessageRepository extends JpaRepository<MessageVo, Integer>, JpaSpecificationExecutor<MessageVo> {
}
