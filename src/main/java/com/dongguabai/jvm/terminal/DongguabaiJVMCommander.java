package com.dongguabai.jvm.terminal;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

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
    @Parameter(names = {"--help", "-h"}, required = false, arity = 0,description = " print the help message")
    private boolean help;

    /**
     * 运行 Java 代码
     */
    @Parameter(names = {"--run"}, required = false, arity = 1,description = "to execute a java file")
    private String run;

    public static void main(String... argv) {
        DongguabaiJVMCommander main = new DongguabaiJVMCommander();
        JCommander jCommander = JCommander.newBuilder()
                .addObject(main)
                .build();
        jCommander.parse(argv);
        main.run(jCommander);
    }

    private void run(JCommander jCommander) {
        if (version) {
            System.out.println(CURRENT_VERSION);
            return;
        }
        if (help) {
            jCommander.usage();
            return;
        }
        if (run != null){
            System.out.printf("execute：%s",run);
        }
    }
}
