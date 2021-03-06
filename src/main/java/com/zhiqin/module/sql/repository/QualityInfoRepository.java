package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.QualityInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by maple on 2017/11/20.
 */
public interface QualityInfoRepository extends JpaRepository<QualityInfo, Integer>, JpaSpecificationExecutor<QualityInfo> {
    Page<QualityInfo> findAllByType(int type, Pageable pageable);
}
