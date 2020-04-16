package com.sunhome.framework.pattern.template.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午5:55
 * @description:
 */
public class LoggerApplication {

    private List<Logger> loggers;

    public LoggerApplication() {
        loggers = new ArrayList<>();
        addLogger(new FileLogger("文件处理器", true, Level.ERROR, "logger_file.txt"));
        addLogger(new MessageQueueLogger("队列处理器", true, Level.INFO));
    }

    public LoggerApplication(List<Logger> loggers) {
        this.loggers = loggers;
    }


    public void log(String message, Level level) {
        for (Logger logger : loggers) {
            logger.log(message, level);
        }
    }


    public void addLogger(Logger logger) {
        loggers.add(logger);
    }

    public void clearLogger() {
        loggers.clear();
    }
}
