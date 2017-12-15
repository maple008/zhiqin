package com.zhiqin.module.sql.repository;

import com.zhiqin.module.sql.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by maple on 2017/11/20.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {
    UserInfo findByMobileAndPwd(String phone, String pwd);

    UserInfo findByMobile(String mobile);
}
