package com.zhiqin.module.utils;

import org.springframework.stereotype.Component;

/****
 * 验证工具类
 *
 * @author panbo
 *
 */
@Component
public class ValidateHelper {

    /**
     * 手机号码认证
     *
     * @param phone
     * @return
     */
    public boolean isPhoneNumber(String phone) {
        return ConstantPatterns.PHONE_PATTERN.matcher(phone).matches();
    }

    /**
     * 邮箱地址验证
     *
     * @param email
     * @return
     */
    public boolean isEmailAddress(String email) {
        return ConstantPatterns.EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * QQ格式验证
     *
     * @param qq
     * @return
     */
    public boolean isQQ(String qq) {
        return ConstantPatterns.QQ_PATTERN.matcher(qq).matches();
    }

    /**
     * 真实姓名验证
     *
     * @param realName
     * @return
     */
    public boolean isRealName(String realName) {
        return ConstantPatterns.REAL_NAME_PATTERN.matcher(realName).matches();
    }

    /**
     * 日期格式验证
     *
     * @param date
     * @return
     */
    public boolean isDate(String date) {
        return ConstantPatterns.DATE_PATTERN.matcher(date).matches();
    }

    /**
     * 数字的认证
     *
     * @param number
     * @return
     */
    public boolean isNumber(String number) {
        return ConstantPatterns.NUMBER_PATTERN.matcher(number).matches();
    }

    /**
     * 评价验证
     *
     * @param remark
     * @return
     */
    public boolean checkRemark(Integer remark) {
        return remark != null && remark <= 5 && remark >= 0;
    }
}
