package com.sunhome.framework.thread.core.chapter4;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 走进lock-小试牛刀
 */
public class LockBootstrap {

    public static void main(String[] args) {


        // 和syn实现的功能一样只不过是显式操作
       final LockService lockService = new LockService();
        new Thread(new Runnable() {
            public void run() {
                lockService.write();

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                lockService.read();

            }
        }).start();

    }


}

@AllArgsConstructor
@NoArgsConstructor
class LockService {

    Lock lock = new ReentrantLock();

    private int count;

    public void read() {
        lock.lock();
        System.out.println(count);
        lock.unlock();

    }

    public void write() {
        lock.lock();
        count += 1;
        lock.unlock();
    }

}

