package com.dongguabai.jvm.util;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-11 16:36
 */
public class CommonUtils {

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv).append(" ");
        }
        return stringBuilder.toString();
    }

    private CommonUtils() {
    }
}
