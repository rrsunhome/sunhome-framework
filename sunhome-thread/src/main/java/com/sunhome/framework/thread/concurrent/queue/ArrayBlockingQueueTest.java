package com.sunhome.framework.thread.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 由数组结构组成的有界阻塞队列
 * add和remove 失败时抛出异常
 * offer 添加失败返回false，poll返回null
 * put和take 失败会一直阻塞
 */
public class ArrayBlockingQueueTest {

    private static ArrayBlockingQueue<Integer> arrayBlockingQueues = new ArrayBlockingQueue<Integer>(1);


    public static void main(String[] args) {
        // testAddAndRemove();
        // testOfferAndPoll();
        // testPutAndTake();

        testOfferAndPollTime();
    }

    /**
     * 测试offer and  poll 超时
     */
    private static void testOfferAndPollTime() {
        arrayBlockingQueues.offer(111);

        // 阻塞插入,超时释放
        try {
            arrayBlockingQueues.offer(10, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(arrayBlockingQueues.poll());


    }

    /**
     * 测试 put and  take
     */
    private static void testPutAndTake() {
        try {
            arrayBlockingQueues.put(11);
            System.out.println(arrayBlockingQueues.take());

            arrayBlockingQueues.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试 offer and  poll
     */
    private static void testOfferAndPoll() {
        // 测试无数据返回
        System.out.println(arrayBlockingQueues.poll());
        arrayBlockingQueues.offer(0);
        System.out.println(arrayBlockingQueues.poll());


    }

    /**
     * 测试 add and remove
     */
    private static void testAddAndRemove() {
        arrayBlockingQueues.add(0);
        arrayBlockingQueues.remove();
        arrayBlockingQueues.remove();
    }
}
