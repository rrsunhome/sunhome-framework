package com.sunhome.framework.thread.core.chapter2;

/**
 * synchronized修饰在方法或代码块 只要为同一个对象监视器就是同步的，不是同一个对象那么就是异步的
 */
public class ThreadMethodBootStrap {


    public static void main(String[] args) {
        PrintService printService = new PrintService();

        ThreadPrintOne threadPrintOne = new ThreadPrintOne(printService);
        ThreadPrintTwo threadPrintTwo = new ThreadPrintTwo(printService);

        threadPrintOne.start();
        threadPrintTwo.start();


    }
}


class ThreadPrintOne extends Thread {

    private PrintService service;

    public ThreadPrintOne(PrintService threadService) {
        this.service = threadService;
    }

    @Override
    public void run() {

        service.printOne();


    }
}

class ThreadPrintTwo extends Thread {

    private PrintService service;

    public ThreadPrintTwo(PrintService threadService) {
        this.service = threadService;
    }

    @Override
    public void run() {

        service.printTwo();

    }
}


class PrintService {


    public synchronized void printOne() {
        for (int i = 0; i < 5; i++) {
            System.out.println("printOne-" + Thread.currentThread().getName());
        }

    }

    public void printTwo() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("printTwo-" + Thread.currentThread().getName());
            }
        }

    }

//    public void printOne() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("printOne-" + Thread.currentThread().getName());
//        }
//
//    }
//
//    public void printTwo() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("printTwo-" + Thread.currentThread().getName());
//        }
//    }


}

