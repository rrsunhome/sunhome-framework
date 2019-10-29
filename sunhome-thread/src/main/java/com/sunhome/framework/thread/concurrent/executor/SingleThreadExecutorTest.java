package com.sunhome.framework.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 数量为1的核心线程数,使用无界队列进行存储
 * 可以保证队列顺序消费
 * <p>
 * new ThreadPoolExecutor(1, 1,
 *                                0L, TimeUnit.MILLISECONDS,
 *                                              new LinkedBlockingQueue<Runnable>())
 * <p>
 */
public class SingleThreadExecutorTest {

    private static ExecutorService singleService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            FixedTask fixedTask = new FixedTask(i);
            singleService.submit(fixedTask);
        }
        singleService.shutdown();
    }
}
