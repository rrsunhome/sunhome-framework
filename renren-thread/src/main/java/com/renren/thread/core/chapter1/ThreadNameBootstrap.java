package com.renren.thread.core.chapter1;

/**
 * 比较 Thread.currentThread().getName()  和this.getName() 不同
 * 生产环境一般用 Thread.currentThread().getName()
 * <p>
 * 线程发生死锁或活锁 线程名称用于快速定位问题
 */
public class ThreadNameBootstrap {


    public static void main(String[] args) {

        ThreadTest3 threadTest = new ThreadTest3();

        Thread run = new Thread(threadTest);

        run.setName("A");
        run.start();


    }
}


class ThreadTest3 extends Thread {

    public ThreadTest3() {

        System.out.println("this.getName() " + this.getName());
    }

    @Override
    public void run() {

        // 指的是执行该线程的对象
        System.out.println(" Thread.currentThread().getName() " + Thread.currentThread().getName());

        // 指的就是当前被调用线程的线程名称
        System.out.println("run  this.getName() " + this.getName());

    }
}



