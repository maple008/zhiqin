package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.CommentVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface CommentVoRepository extends JpaRepository<CommentVo, Integer>, JpaSpecificationExecutor<CommentVo> {
    List<CommentVo> findAllByResourceId(int resourceId);
}
