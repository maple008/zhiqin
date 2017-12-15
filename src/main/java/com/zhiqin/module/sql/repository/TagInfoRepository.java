package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.TagInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface TagInfoRepository extends JpaRepository<TagInfo, Integer>, JpaSpecificationExecutor<TagInfo> {
    @Query(value = "select t.id,t.PARENT_ID,t.CODE_ID,t.tag_parent_id,c.name from tag t left join tag_code c ON  c.id=t.code_id where PARENT_ID=?1", nativeQuery = true)
    List<TagInfo> findAllByParentId(int parentId);

    @Query(value = "select t.id,t.PARENT_ID,t.CODE_ID,t.tag_parent_id,c.name from tag t left join tag_code c ON  c.id=t.code_id where code_id=?1", nativeQuery = true)
    List<TagInfo> findAllByCodeId(int parentId);

}
