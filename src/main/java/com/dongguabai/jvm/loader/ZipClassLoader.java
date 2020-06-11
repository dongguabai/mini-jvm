package com.dongguabai.jvm.loader;

/**
 * @author Dongguabai
 * @Description 解析 Zip
 * @Date 创建于 2020-06-11 12:22
 */
public class ZipClassLoader extends ClassLoader{

    ZipClassLoader(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] loadClass(String classFile) {
        System.out.printf("ZipClassLoader:[%s]",classFile);
        //todo
        return null;
    }
}
