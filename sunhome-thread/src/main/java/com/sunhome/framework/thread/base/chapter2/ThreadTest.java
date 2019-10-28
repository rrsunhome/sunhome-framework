package com.sunhome.framework.thread.base.chapter2;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadUpdate threadUpdate = new ThreadUpdate();

        threadUpdate.update();

        threadUpdate.read();


    }
}

@Getter
class ThreadUpdate {

    private int num = 0;

    public void update() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("n"+num);
                num = 4;
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void read() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(num);
    }
}

