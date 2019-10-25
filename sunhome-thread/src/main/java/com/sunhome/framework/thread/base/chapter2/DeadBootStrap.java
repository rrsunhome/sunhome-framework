package com.sunhome.framework.thread.base.chapter2;

/**
 * 采用syn解决可见性原子性
 */
public class DeadBootStrap {

    private static Object a = new Object();

    private static Object b = new Object();


    public static void main(String[] args) {


        deadLock();


    }

    private static void deadLock() {


        new Thread(new Runnable() {
            public void run() {
                synchronized (a) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        System.out.println("AA");
                    }


                }


            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                synchronized (b) {
                    synchronized (a) {
                        System.out.println("AA");
                    }


                }


            }
        }).start();


    }


}




