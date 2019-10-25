package com.sunhome.framework.thread.base.chapter3;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class SortBootStrap {


    public static void main(String[] args) {
        SortService sortService = new SortService();

        SortThread sortThread1 = new SortThread("A", 0, sortService);
        SortThread sortThread2 = new SortThread("B", 1, sortService);
        SortThread sortThread3 = new SortThread("C", 2, sortService);

        sortThread1.start();
        sortThread2.start();
        sortThread3.start();


    }
}


class SortService {

    // 全局控制
    private int num;

    public synchronized void sort(SortThread sortThread) {
        while (num != sortThread.getSort()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sortThread.getFieldName());

        num = (num + 1) % 3;
        this.notifyAll();
    }


}

@Getter
@AllArgsConstructor
class SortThread extends Thread {
    private String fieldName;
    private int sort;

    private SortService sortService;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sortService.sort(this);
        }

    }


}
