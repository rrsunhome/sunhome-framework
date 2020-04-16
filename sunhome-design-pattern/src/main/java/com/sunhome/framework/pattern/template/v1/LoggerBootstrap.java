package com.sunhome.framework.pattern.template.v1;

import java.util.concurrent.TimeUnit;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午6:04
 * @description:
 */
public class LoggerBootstrap {


    public static void main(String[] args) {

        LoggerApplication loggerApplication = new LoggerApplication();
        // 文件日志不处理
        loggerApplication.log("今天周末,阳光很好", Level.INFO);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loggerApplication.log("今天周末,乌云密布", Level.ERROR);
        // 文件日志不处理
        loggerApplication.log("今天周末,适合野游", Level.INFO);



    }
}
