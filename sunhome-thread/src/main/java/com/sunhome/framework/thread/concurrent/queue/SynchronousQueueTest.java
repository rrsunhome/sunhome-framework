package com.sunhome.framework.thread.concurrent.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * 不存储元素的阻塞队列
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue();
        // TODO Auto-generated method stub

        for (int i = 0; i < 5; i++)
            new Thread(new ThreadProducer(queue)).start();
        for (int i = 0; i < 5; i++)
            new Thread(new ThreadConsumer(queue)).start();
    }
}

class ThreadProducer implements Runnable {
    ThreadProducer(SynchronousQueue<String> queue) {
        this.queue = queue;
    }

    SynchronousQueue<String> queue;

    public void run() {
        String name = "";
        name = "offer name:" + Thread.currentThread().getName();
        try {
            queue.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadConsumer implements Runnable {
    ThreadConsumer(SynchronousQueue<String> queue) {
        this.queue = queue;
    }

    SynchronousQueue<String> queue;

    public void run() {
        String name;

        try {
            //  System.out.println("begin");
            Thread.sleep(3000);
            name = queue.take();
            System.out.println("take " + name);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
