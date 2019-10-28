package com.sunhome.framework.thread.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        // 以原子方式更新新值
        atomicInteger.getAndSet(10);
        // 将当前值加1
        atomicInteger.getAndIncrement();

        atomicInteger.addAndGet(5);

        atomicInteger.compareAndSet(16, 1);

        System.out.println(atomicInteger.get());

    }
}
