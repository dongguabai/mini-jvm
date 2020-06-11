package com.dongguabai.jvm.loader;

/**
 * @author Dongguabai
 * @Description ClassLoader 工厂
 * @Date 创建于 2020-06-11 12:21
 */
public class ClassLoaderFactory {

    public static ClassLoader getClassLoader(String classPath){
        //todo 生成 ClassLoader
        return new DirClassLoader(classPath);
    }

    private ClassLoaderFactory() {
    }
}
