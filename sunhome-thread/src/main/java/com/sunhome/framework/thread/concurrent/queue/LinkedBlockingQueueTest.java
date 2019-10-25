package com.sunhome.framework.thread.concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 由链表结构组成的阻塞队列
 */
public class LinkedBlockingQueueTest {
    /**
     * 初始化大小时代表有界否则无界队列
     */
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);


    public static void main(String[] args) {

        // 抛出异常,则代表有界阻塞队列
        linkedBlockingQueue.add(1);
        linkedBlockingQueue.add(1);
    }
}
