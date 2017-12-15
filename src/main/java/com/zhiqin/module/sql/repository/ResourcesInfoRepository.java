package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.ResourcesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by maple on 2017/11/20.
 */
public interface ResourcesInfoRepository extends JpaRepository<ResourcesInfo, Integer>, JpaSpecificationExecutor<ResourcesInfo> {

}
