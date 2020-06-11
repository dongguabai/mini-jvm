package com.dongguabai.jvm.loader;

import com.dongguabai.jvm.util.IOUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Dongguabai
 * @Description 解析目录
 * @Date 创建于 2020-06-11 15:03
 */
public class DirClassLoader extends ClassLoader {

    public DirClassLoader(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] loadClass(String classFile) {
        System.out.printf("DirClassLoader:[%s]\n", classFile);
        String filePath = getClassPath() + File.separator + classFile;
        try {
            return IOUtils.toByte(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
