package com.sunhome.framework.thread.base.chapter3;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生产、消费模式
 * synchronized 非公平锁会出现生产者重复持锁问题
 */
@Data
public class PCBootstrap {


    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            Producer producer = new Producer(lock);

            public void run() {
                for (int i = 0; i < 10; i++) {
                    producer.send();
                }

            }
        }).start();

        new Thread(new Runnable() {
            Consumer consumer = new Consumer(lock);

            public void run() {

                for (int i = 0; i < 10; i++) {
                    consumer.listen();
                }


            }
        }).start();
    }

}


@Data
@AllArgsConstructor
class Producer {


    private Object lock;


    public void send() {
        synchronized (lock) {


            if (MessageUtils.messageList.size() >= 1) {
                try {
                    System.out.println("生产者阻塞:" + MessageUtils.messageList.size());
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            MessageUtils.messageList.add("body" + new Random().nextInt(500));

            lock.notify();
        }


    }


}

@Data
@AllArgsConstructor
class Consumer {

    private Object lock;


    public void listen() {
        synchronized (lock) {
            if (MessageUtils.messageList.size() == 0) {
                try {
                    System.out.println("消费者阻塞");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费消息:" + MessageUtils.messageList.get(0));
            MessageUtils.messageList.remove(0);
            lock.notify();

        }

    }


}

@Data
class MessageUtils {

    public static List<String> messageList = new ArrayList<String>();


}






