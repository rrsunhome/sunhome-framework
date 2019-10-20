package com.framework.sunhome.thread.core.chapter2;

/**
 * synchronized 修饰静态方法时，类的所属对象相同锁或类.方法共享一把，则类中所有静态方法都是同步的(必须是同一把锁)
 *
 * 出现访问一个类多个方法锁监视器不相同时，则方法不是同步的
 */
public class ThreadStaticBootStrap {


    public static void main(String[] args) {
        PrintStaticService printStaticService = new PrintStaticService();

        PrintStaticService printStaticService1 = new PrintStaticService();

        PrintStaticService printStaticService2 = new PrintStaticService();


        ThreadStaticPrintOne threadPrintOne = new ThreadStaticPrintOne(printStaticService);
        ThreadStaticPrintTwo threadPrintTwo = new ThreadStaticPrintTwo(printStaticService1);

        ThreadStaticPrintThree threadPrintThree = new ThreadStaticPrintThree(printStaticService2);


        threadPrintOne.start();
        threadPrintTwo.start();
        threadPrintThree.start();


    }
}


class ThreadStaticPrintOne extends Thread {

    private PrintStaticService service;

    public ThreadStaticPrintOne(PrintStaticService threadService) {
        this.service = threadService;
    }

    @Override
    public void run() {

        //  service.printOne();
        PrintStaticService.printOne();


    }
}

class ThreadStaticPrintTwo extends Thread {

    private PrintStaticService service;

    public ThreadStaticPrintTwo(PrintStaticService threadService) {
        this.service = threadService;
    }

    @Override
    public void run() {
        PrintStaticService.printTwo();
        //service.printTwo();

    }
}

class ThreadStaticPrintThree extends Thread {

    private PrintStaticService service;

    public ThreadStaticPrintThree(PrintStaticService threadService) {
        this.service = threadService;
    }

    @Override
    public void run() {

        service.printThree();

    }
}


class PrintStaticService {


    public synchronized static void printOne() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printOne-" + Thread.currentThread().getName());
        }

    }

    public synchronized static void printTwo() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printTwo-" + Thread.currentThread().getName());
        }


    }

    public synchronized void printThree() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printTwo-" + Thread.currentThread().getName());
        }


    }


}

