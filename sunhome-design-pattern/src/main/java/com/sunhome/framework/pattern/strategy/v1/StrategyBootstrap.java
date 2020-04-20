package com.sunhome.framework.pattern.strategy.v1;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午2:25
 */
public class StrategyBootstrap {

    public static void main(String[] args) {
        VersionPathStrategy fileNameVersionPathStrategy = new FileNameVersionPathStrategy();
        String version = fileNameVersionPathStrategy.extractVersion("path/foo-123213.css");
        System.out.println(version);


        VersionPathStrategy prefixVersionPathStrategy = new PrefixVersionPathStrategy("123");
        String version1 = prefixVersionPathStrategy.extractVersion("123/path/foo.js");
        System.out.println(version1);
    }
}
