package com.sunhome.framework.thread.base.chapter2;

import lombok.Data;

/**
 * 采用volatile的可见性原理停止线程
 */
public class PrintStringBootStrap {

    public static void main(String[] args) {

        PrintString printString = new PrintString();
        printString.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printString.setContinuePrint(false);

    }
}

@Data
class PrintString extends Thread {
    private volatile boolean isContinuePrint = true;


    @Override
    public void run() {
        print();
    }

    private void print() {
        while (this.isContinuePrint) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("dead while");
        }

    }


}