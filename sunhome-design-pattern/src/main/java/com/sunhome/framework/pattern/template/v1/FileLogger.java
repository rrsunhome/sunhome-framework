package com.sunhome.framework.pattern.template.v1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午5:22
 * @description:
 */
public class FileLogger extends Logger {

    private Writer writer;

    private MessageFormatter messageFormatter;

    public FileLogger(String name, boolean enabled, Level minLevel, String filePath) {
        super(name, enabled, minLevel);
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException("创建异常");
        }
        messageFormatter = new JsonMessageFormatter();
    }

    @Override
    protected void doLog(String message, Level level) {
        try {
            writer.write(messageFormatter.format(message, level) + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
