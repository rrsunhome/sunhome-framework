package com.sunhome.framework.thread.concurrent.executor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledTest {

    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    //DateTimeFormatter,LocalDateTime 线程安全
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public static void main(String[] args) {
        Thread timeTask = new Thread(() -> {

            try {
                System.out.println("begin time:" + LocalDateTime.now().format(dateTimeFormatter));

                // TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }


        });
        // 指定间隔内完成调度，一次性
        //  executorService.schedule(thread, 2, TimeUnit.SECONDS);
        // 不延迟，时间每三秒执行一次
        // 延迟， 任务在上次执行完立马执行
        //executorService.scheduleAtFixedRate(timeTask, 1, 2, TimeUnit.SECONDS);

        // 每延迟指定时间执行一次(上一次任务的结束与下一次任务的开始为指定时间),延迟和不延迟都是在指定延迟时间内执行
        executorService.scheduleWithFixedDelay(timeTask, 1, 2, TimeUnit.SECONDS);


    }
}
