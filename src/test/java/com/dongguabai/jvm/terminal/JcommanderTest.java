package com.dongguabai.jvm.terminal;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-08 10:34
 */
public class JcommanderTest {

    @Parameter(names={"--length", "-l"})
    int length;
    @Parameter(names={"--pattern", "-p"})
    int pattern;

    public static void main(String ... argv) {
        JcommanderTest main = new JcommanderTest();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(argv);
        main.run();
    }

    public void run() {
        System.out.printf("%d %d", length, pattern);
    }
}
