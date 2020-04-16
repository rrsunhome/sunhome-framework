package com.sunhome.framework.pattern.template.v1;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午5:13
 * @description:
 */
public enum Level {

    INFO(1),
    ERROR(2);

    private Integer value;

    Level(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
