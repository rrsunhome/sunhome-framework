package com.sunhome.framework.thread.concurrent.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 链表实现的无界非阻塞线程安全队列，遵循先入先出规则。
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (int i = 0; i < 10; i++) {
            concurrentLinkedQueue.offer(i);
        }

        Object val = concurrentLinkedQueue.poll();
        System.out.println(val);
        System.out.println(concurrentLinkedQueue.size());



    }
}
