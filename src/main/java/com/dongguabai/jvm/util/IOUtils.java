package com.dongguabai.jvm.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-11 16:18
 */
public class IOUtils {

    public static byte[] toByte(String filePath) throws IOException {
        File f = new File(filePath);
        FileInputStream input = new FileInputStream(f);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n;
        for (; -1 != (n = input.read(buffer)); ) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    private IOUtils() {
    }
}
