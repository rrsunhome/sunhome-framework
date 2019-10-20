package com.sunhome.framework.thread.core.chapter2;

/**
 * 采用syn解决可见性原子性
 */
public class ThreadSynBootStrap {


    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();

        ThreadAdd threadAdd1 = new ThreadAdd(threadService);
        ThreadAdd threadAdd2 = new ThreadAdd(threadService);

        threadAdd1.start();
        threadAdd2.start();

        // 不加同步锁会出现线程竞争问题，导致数值过程中不正确
        try {
            // 等待总线程执行完成
            threadAdd1.join();
            threadAdd2.join();

            System.out.println("总数量:" + threadService.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}


class ThreadAdd extends Thread {

    private ThreadService service;

    public ThreadAdd(ThreadService threadService) {
        this.service = threadService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            service.addCount();
        }

    }
}

class ThreadService {
    private int count;

    // 模拟不加锁时
    public void addCount() {

        // 模拟业务耗时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;
    }

//    public synchronized void addCount() {
//
//        // 模拟业务耗时
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        count++;
//    }

    public int getCount() {
        return count;
    }
}

