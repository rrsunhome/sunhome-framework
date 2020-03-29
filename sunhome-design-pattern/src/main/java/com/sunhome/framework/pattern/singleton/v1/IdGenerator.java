package com.sunhome.framework.pattern.singleton.v1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 提前加载（按照有问题提前报漏原则，如果项目启动过程中发现内存不足，提前解决）
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:54
 * @description:
 */
public class IdGenerator {

    private AtomicInteger id = new AtomicInteger(0);

    private static final IdGenerator ID_GENERATOR = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return ID_GENERATOR;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}

