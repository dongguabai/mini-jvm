package com.dongguabai.jvm.loader;

/**
 * @author Dongguabai
 * @Description ClassLoader 抽象类
 * @Date 创建于 2020-06-11 12:21
 */
public abstract class ClassLoader {

    private String classPath;

    public abstract byte[] loadClass(String classFile);

    ClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public String getClassPath() {
        return classPath;
    }
}
