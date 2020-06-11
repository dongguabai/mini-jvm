package com.dongguabai.jvm.util;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-11 12:12
 */
public class StringUtils {

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    private StringUtils(){}
}
