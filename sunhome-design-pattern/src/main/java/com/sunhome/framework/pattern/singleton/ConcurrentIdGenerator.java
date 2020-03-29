package com.sunhome.framework.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午1:00
 * @description:
 */
public class ConcurrentIdGenerator {


    private ExecutorService executorService;


    public ConcurrentIdGenerator() {
        this.executorService = Executors.newFixedThreadPool(20);
    }


    public void execute(IdCallback idCallback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                idCallback.doHandle();
            }
        });
    }

}
