package com.dongguabai.jvm.loader;

/**
 * @author Dongguabai
 * @Description 解析 Jar
 * @Date 创建于 2020-06-11 12:22
 */
public class JarClassLoader extends ClassLoader{

    public JarClassLoader(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] loadClass(String classFile) {
        System.out.printf("JarClassLoader:[%s]",classFile);
        //todo
        return null;
    }
}
