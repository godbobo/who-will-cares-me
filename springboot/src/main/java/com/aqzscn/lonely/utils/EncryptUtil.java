package com.aqzscn.lonely.utils;

import org.springframework.util.DigestUtils;

public class EncryptUtil {

    private static final String slat = "aqzscn.com";

    /**
     * 生成md5加密字符串
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String buildMd5(String str) {
        if (str == null) {
            str = "nullstr";
        }
        str += slat;
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}
