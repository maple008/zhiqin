package com.zhiqin.module.service;

import com.zhiqin.module.dto.UserInfoDto;
import com.zhiqin.module.sql.entity.UserInfo;
import com.zhiqin.module.sql.repository.UserInfoRepository;
import com.zhiqin.module.utils.BeanCopyUtils;
import com.zhiqin.module.utils.EncryptHelper;
import com.zhiqin.module.utils.RespBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * Created by maple on 2017/11/24.
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private EncryptHelper encryptHelper;

    public RespBase<String> register(UserInfoDto userInfoDto) {
        RespBase<String> respBase = new RespBase<>();
        UserInfo userInfo = userInfoRepository.findByMobile(userInfoDto.getMobile());
        if (Objects.nonNull(userInfo) && Objects.nonNull(userInfo.getId())) {
            respBase.setErrorCode(-1);
            respBase.setErrorMsg("账户已存在！");
        } else {
            userInfo = new UserInfo();
        }
        BeanCopyUtils.copyProperties(userInfoDto, userInfo);
        // 加密密码
        String encodeStr = encryptHelper.encryptWords(userInfo.getPwd());
        userInfo.setPwd(encodeStr);
        userInfo.setCreateTime(new Date());
        UserInfo save = userInfoRepository.save(userInfo);
        respBase.setResult(save.getId().toString());
        return respBase;
    }

    public RespBase<UserInfoDto> login(UserInfoDto userInfoDto) {
        RespBase<UserInfoDto> respBase = new RespBase<>();
        // 加密密码
        String encodeStr = encryptHelper.encryptWords(userInfoDto.getPwd());
        UserInfo userInfo = userInfoRepository.findByMobileAndPwd(userInfoDto.getMobile(), encodeStr);
        if (Objects.nonNull(userInfo) && Objects.nonNull(userInfo.getId())) {
            UserInfoDto DTO = new UserInfoDto();
            BeanCopyUtils.copyProperties(userInfo, DTO);
            respBase.setResult(DTO);
        } else {
            respBase.setErrorCode(-1);
            respBase.setErrorMsg("账号密码错误！");
        }
        return respBase;
    }

}
