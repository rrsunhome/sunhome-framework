package com.sunhome.framework.pattern.template.v1;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午5:13
 * @description:
 */
public abstract class Logger {
    /**
     * 名称
     */
    private String name;
    /**
     * 是否开启
     */
    private boolean enabled;
    /**
     * 最小级别
     */
    private Level minLevel;

    public Logger(String name, boolean enabled, Level minLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minLevel = minLevel;
    }

    public void log(String message, Level level) {
        boolean loggable = enabled && !minLevel.name().equals(level.name());
        if (!loggable) {
            return;
        }
        doLog(message, level);
    }

    protected abstract void doLog(String message, Level level);


}
