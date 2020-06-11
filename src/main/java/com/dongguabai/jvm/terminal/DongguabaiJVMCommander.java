package com.dongguabai.jvm.terminal;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.SubParameter;
import com.dongguabai.jvm.loader.ClassLoader;
import com.dongguabai.jvm.loader.ClassLoaderFactory;
import com.dongguabai.jvm.util.CommonUtils;
import com.dongguabai.jvm.util.StringUtils;


/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-08 13:36
 */
public class DongguabaiJVMCommander {

    private static final String CURRENT_VERSION = "Dongguabai jdk version \"0.0.1\"";

    /**
     * 查看版本
     */
    @Parameter(names = {"--version", "-v"}, required = false, arity = 0, description = "print product version and exit")
    private boolean version;

    /**
     * help
     */
    @Parameter(names = {"--help", "-h"}, required = false, arity = 0, description = " print the help message")
    private boolean help;

    /**
     * 运行 Java 代码
     */
    @Parameter(names = {"--run"}, required = false, arity = 1, description = "to execute a java file")
    private String run;


    /**
     * class load
     */
    @Parameter(names = {"-cp", "--classpath"}, required = false, arity = 2, description = "class search path of directories and zip/jar files")
    private ClassPathParams classPathParams;

    public static void main(String... argv) {
        DongguabaiJVMCommander main = new DongguabaiJVMCommander();
        JCommander jCommander = JCommander.newBuilder()
                .addObject(main)
                .build();
        jCommander.parse(argv);
        main.run(jCommander);
    }

    /**
     * 运行
     * todo 优化
     *
     * @param jCommander
     */
    private void run(JCommander jCommander) {
        if (version) {
            System.out.println(CURRENT_VERSION);
            return;
        }
        if (help) {
            jCommander.usage();
            return;
        }
        if (classPathParams != null && StringUtils.isNotBlank(classPathParams.classFile) && StringUtils.isNotBlank(classPathParams.classPath)) {
            System.out.printf("load Class：%s  %s\n", classPathParams.classPath, classPathParams.classFile);
            loadClasspath();
        }
        if (StringUtils.isNotBlank(run)) {
            System.out.printf("execute：%s", run);
        }
    }

    private void loadClasspath() {
        ClassLoader classLoader = ClassLoaderFactory.getClassLoader(classPathParams.classPath);
        byte[] bytes = classLoader.loadClass(classPathParams.classFile);
        String s = CommonUtils.bytesToHexString(bytes);
        System.out.println(s);
    }

    public static class ClassPathParams {
        @SubParameter(order = 0)
        public String classPath;

        @SubParameter(order = 1)
        public String classFile;

        public ClassPathParams() {
        }
    }
}
