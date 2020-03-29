package com.sunhome.framework.pattern.singleton.v4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:54
 * @description:
 */
public enum IdGenerator {

    INSTANCE;

    private AtomicInteger id = new AtomicInteger(0);

    public long getId() {
        return id.incrementAndGet();
    }


}

