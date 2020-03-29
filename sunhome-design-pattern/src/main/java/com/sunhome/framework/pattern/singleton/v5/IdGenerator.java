package com.sunhome.framework.pattern.singleton.v5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:54
 * @description:
 */
public abstract class IdGenerator {


    private static AtomicInteger id = new AtomicInteger(0);

    public static long getId() {
        return id.incrementAndGet();
    }


}

