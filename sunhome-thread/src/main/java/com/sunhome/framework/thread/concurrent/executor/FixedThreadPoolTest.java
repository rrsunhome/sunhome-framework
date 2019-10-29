package com.sunhome.framework.thread.concurrent.executor;

import lombok.AllArgsConstructor;

import java.util.concurrent.*;

/**
 * 创建固定的线程，使用无界队列存储消息
 * new ThreadPoolExecutor(nThreads, nThreads,
 * 0L, TimeUnit.MILLISECONDS,
 * new LinkedBlockingQueue<Runnable>());
 * 核心线程数=最大线程数，所以存活时间无用
 */
public class FixedThreadPoolTest {

    private static ExecutorService fixedPoolService = Executors.newFixedThreadPool(2);


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            FixedTask fixedTask = new FixedTask(i);
            Future<String> futureResult = fixedPoolService.submit(fixedTask);
            //print(futureResult);

        }
        fixedPoolService.shutdown();

    }

    private static void print(Future<String> futureResult) {
        try {
            System.out.println("task value:" + futureResult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

@AllArgsConstructor
class FixedTask implements Callable<String> {

    private int index;

    @Override
    public String call() throws Exception {
        System.out.println(index);
        return "current:" + index;
    }
}
