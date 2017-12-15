package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.TagResources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface TagResourceRepository extends JpaRepository<TagResources, Integer>, JpaSpecificationExecutor<TagResources> {
    Page<TagResources> findAllByTagIdAndTagParentId(int tag_id, String tag_parent_id,Pageable pageable);
    @Query(value = "select r.* from tag  t LEFT JOIN tag_resources  r ON t.id=r.TAG_ID where t.id=r.TAG_ID and t.tag_parent_id=r.TAG_PARENT_ID   and t.CODE_ID=?1", nativeQuery = true)
    List<TagResources> findAllByCodeId(int codeId);
}
