package com.sunhome.framework.thread.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    public static void main(String[] args) {

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);

        atomicIntegerArray.addAndGet(0, 10);

        atomicIntegerArray.compareAndSet(0, 10, 20);

        System.out.println(atomicIntegerArray.get(0));
    }
}
