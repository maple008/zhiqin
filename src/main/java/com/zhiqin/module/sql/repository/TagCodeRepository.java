package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.TagCode;
import com.zhiqin.module.sql.entity.TagInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface TagCodeRepository extends JpaRepository<TagCode, Integer>, JpaSpecificationExecutor<TagCode> {

    @Query(value = "select *  from tag_code where id like ?1%", nativeQuery = true)
    List<TagCode> findAllType(int id);
}
