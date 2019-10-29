package com.sunhome.framework.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 核心线程数为0，最大线程数Integer最大值，因为是线程最大数原因可能会造成cpu和内存资源耗尽
 * <p>
 * new ThreadPoolExecutor(0, Integer.MAX_VALUE,
 * 60L, TimeUnit.SECONDS,
 * new SynchronousQueue<Runnable>())
 */
public class CachedThreadPoolTest {

    private static ExecutorService cacheService = Executors.newCachedThreadPool();



    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            FixedTask fixedTask = new FixedTask(i);
            Future<String> futureResult = cacheService.submit(fixedTask);

        }
        cacheService.shutdown();


    }
}
