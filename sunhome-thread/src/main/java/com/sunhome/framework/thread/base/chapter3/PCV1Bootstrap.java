package com.sunhome.framework.thread.base.chapter3;


import lombok.Data;

/**
 * 利用等待/唤醒机制 循环打印inset select 字段
 * <p>
 * notifyAll 唤醒所有的线程，但是唤醒所有线程中只允许其中一个线程持有锁
 */
@Data
public class PCV1Bootstrap {


    public static void main(String[] args) {
        final DBUtils dbUtils = new DBUtils();


        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {

                public void run() {
                    dbUtils.insert();

                }
            }).start();

//            new Thread(new Runnable() {
//
//                public void run() {
//                    dbUtils.select();
//
//                }
//            }).start();

        }


        new Thread(new Runnable() {

            public void run() {
                dbUtils.select();

            }
        }).start();


    }
}

class DBUtils {

    private boolean isSelect = false;


    public synchronized void select() {
        while (isSelect == false) {
            System.out.println(Thread.currentThread().getName() + "select wait");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isSelect = false;
        System.out.println(Thread.currentThread().getName() + ":SELECT");
        this.notifyAll();
    }


    public synchronized void insert() {
        while (isSelect == true) {
            System.out.println(Thread.currentThread().getName() + "insert wait");
            try {
                this.wait();
                System.out.println("唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isSelect = true;
        System.out.println(Thread.currentThread().getName() + ":INSERT");
        this.notifyAll();
    }
}










