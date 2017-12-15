package com.zhiqin.module.utils;

import java.util.regex.Pattern;

/**
 * 正则常量类
 * @author panbo
 */
public final class ConstantPatterns {

    /**
     * 手机号码
     */
    public final static Pattern PHONE_PATTERN = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\d{8}$");
    /**
     * 邮箱地址
     */
    public final static Pattern EMAIL_PATTERN = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    /**
     * QQ格式
     */
    public final static Pattern QQ_PATTERN = Pattern.compile("^\\d{5,10}$");
    /**
     * 真实姓名
     */
    public final static Pattern REAL_NAME_PATTERN = Pattern.compile("^[\u4e00-\u9fa5]{2,}$");
    /**
     * 日期格式
     */
    public final static Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}");
    /**
     * 数字
     */
    public final static Pattern NUMBER_PATTERN = Pattern.compile("^\\d+");
    /**
     * 昵称包含中文字符判断
     */
    public final static Pattern CHAR_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");
}
