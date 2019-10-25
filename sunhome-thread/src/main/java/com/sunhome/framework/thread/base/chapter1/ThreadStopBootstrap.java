package com.sunhome.framework.thread.base.chapter1;

/**
 * 线程停止
 */
public class ThreadStopBootstrap {

    public static void main(String[] args) throws InterruptedException {

        ThreadStop threadStop = new ThreadStop();
        threadStop.start();

        Thread.sleep(1000);

        // 线程停止
        threadStop.interrupt();

    }
}

class ThreadStop extends Thread {
    int num;

    @Override
    public void run() {
        for (; ; ) {
            if (this.interrupted()) {
                System.out.println(Thread.interrupted());
                break;
            }
            num++;
            System.out.println(num);

        }
    }
}




