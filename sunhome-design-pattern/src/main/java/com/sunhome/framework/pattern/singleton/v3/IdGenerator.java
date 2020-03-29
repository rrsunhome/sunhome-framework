package com.sunhome.framework.pattern.singleton.v3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:54
 * @description:
 */
public class IdGenerator {

    private AtomicInteger id = new AtomicInteger(0);


    private static class IdHolder {
        private static final IdGenerator INSTANCE = new IdGenerator();
    }

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return IdHolder.INSTANCE;
    }

    public long getId() {
        return id.incrementAndGet();
    }


}

