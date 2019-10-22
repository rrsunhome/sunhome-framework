package com.sunhome.framework.thread.core.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 等待/唤醒机制
 */
public class LockConditionBootstrap {

    public static void main(String[] args) {

        final ConditionService conditionService = new ConditionService();

        new Thread(new Runnable() {
            public void run() {
                conditionService.await();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            public void run() {
                conditionService.signal();
            }
        }).start();

    }


}

class ConditionService {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public void await() {
        lock.lock();
        System.out.println("begin condition await");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end condition await");

        lock.unlock();

    }

    public void signal() {
        System.out.println("begin condition signal");

        lock.lock();
        condition.signal();
        System.out.println("end condition signal");

        lock.unlock();


    }

}


