package com.sunhome.framework.pattern.observer.v2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangqijia
 * create at:  2020/4/22  上午10:48
 */
public class EventBootstrap {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        EventBus eventBus = new AsyncEventBus(executorService);

        eventBus.register(new EventMonitor());

        eventBus.post(Long.valueOf(12));


        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }


    private static class EventMonitor {

        @Subscribe
        public void process(Long id) {
            System.out.println(Thread.currentThread().getName() + id);
        }
    }
}
