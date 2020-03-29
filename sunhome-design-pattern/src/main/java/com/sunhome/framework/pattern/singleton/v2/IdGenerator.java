package com.sunhome.framework.pattern.singleton.v2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:54
 * @description:
 */
public class IdGenerator {

    private AtomicInteger id = new AtomicInteger(0);

    private static IdGenerator ID_GENERATOR;

    private IdGenerator() {
    }

    public static synchronized IdGenerator getInstance() {
        if (ID_GENERATOR == null) {
            ID_GENERATOR = new IdGenerator();
        }
        return ID_GENERATOR;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}

