package com.sunhome.framework.thread.base.chapter2;

import lombok.Data;

/**
 * 采用volatile的可见性原理停止线程
 */
public class PrintStringBootStrap {

    public static void main(String[] args) throws InterruptedException {

        PrintString printString = new PrintString();
        printString.start();


        Thread.sleep(1000);

        printString.stopMe();

    }
}

class PrintString extends Thread {

    private boolean stop = false;

    @Override
    public void run() {
        print();
    }

    private void print() {
        int i = 0;
        while (!stop) {
            i++;
            // 打印方法中存在synchronized，保证了可见性
            System.out.println(stop);
        }

    }

    public void stopMe() {
        stop = true;
    }

}