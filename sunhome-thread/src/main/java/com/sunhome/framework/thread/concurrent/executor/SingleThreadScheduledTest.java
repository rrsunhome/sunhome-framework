package com.sunhome.framework.thread.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledTest {

    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("任务" + System.currentTimeMillis());
        });
        executorService.schedule(thread, 2, TimeUnit.SECONDS);

    }
}




