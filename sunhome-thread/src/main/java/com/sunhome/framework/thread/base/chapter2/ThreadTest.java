package com.sunhome.framework.thread.base.chapter2;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadUpdate threadUpdate = new ThreadUpdate();

        threadUpdate.update();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadUpdate.read();
//        System.out.println();


    }
}

@Getter
class ThreadUpdate {

    private int num = 0;

    public void update() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                num = 4;
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void read() {
        System.out.println(num);
    }
}

