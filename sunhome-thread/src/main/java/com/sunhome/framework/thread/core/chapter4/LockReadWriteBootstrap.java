package com.sunhome.framework.thread.core.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试demo
 * 读锁之间不互斥
 * 读写或谢谢互斥
 * 结论:涉及到写都互斥
 */
public class LockReadWriteBootstrap {

    public static void main(String[] args) {
        final ReadWriteService readWriteService = new ReadWriteService();
        //
//        new Thread(() -> {
//            readWriteService.read();
//        }).start();
//        new Thread(() -> {
//            readWriteService.read();
//        }).start();
        new Thread(() -> {
            readWriteService.write();
        }).start();
        new Thread(() -> {
            readWriteService.write();
        }).start();

    }
}


class ReadWriteService {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();

    private Lock writeLock = readWriteLock.writeLock();


    public void read() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
        readLock.unlock();
    }

    public void write() {
        writeLock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
        writeLock.unlock();
    }


}
