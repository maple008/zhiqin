package com.zhiqin.module.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***
 * 加密工具类
 * @author panbo
 *
 */
@Component
public class EncryptHelper {

    //SHA256加密
    public String encryptWords(String words) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(words.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return byte2Hex(md.digest());
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes
     * @return
     */

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
