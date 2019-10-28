package com.sunhome.framework.thread.concurrent.control;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierTest {
    private static CyclicBarrier c = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("first process");
        }
    });
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        new Thread(()->{
            try {
                System.out.println("thread begin");
                c.await();
                System.out.println("thread end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("main begin");
        c.await();
        System.out.println("main end");






    }
}
