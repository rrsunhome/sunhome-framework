package com.sunhome.framework.thread.base.chapter1;

/**
 *
 * 介绍线程的启动 start currentThread sleep 使用
 *
 */
public class ThreadStartBootstrap {

    public static void main(String[] args) {
        // extends
        ThreadTest1 threadTest1 = new ThreadTest1();
        threadTest1.setName("extends A");
        threadTest1.start();

        // implements
        Thread thread = new Thread(new ThreadTest2());
        thread.setName("implements B ");
        thread.start();


    }
}


class ThreadTest1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);

            System.out.println("extends Thread -" + Thread.currentThread().getName());
            System.out.println();
            System.out.println("extends Thread -isAlive-" + this.isAlive());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class ThreadTest2 implements Runnable {

    public void run() {
        System.out.println("implements Thread-" + Thread.currentThread().getName());
        System.out.println("implements Thread isAlive-" + Thread.currentThread().isAlive());

    }
}



