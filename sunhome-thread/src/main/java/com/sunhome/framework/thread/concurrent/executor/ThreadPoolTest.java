package com.sunhome.framework.thread.concurrent.executor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    /**
     * 创建有界队列
     */
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5,
            10, TimeUnit.SECONDS, new LinkedBlockingDeque(4), new TestThreadFactory());

    public static void main(String[] args) {



        for (int i = 0; i < 6; i++) {
            Thread command = new Thread(() -> {
                try {
                    System.out.println("currentName:"+ Thread.currentThread().getName());
                    System.out.println("线程池大小:" + threadPoolExecutor.getPoolSize());
                    System.out.println("线程池存活数量:" + threadPoolExecutor.getActiveCount());
                    System.out.println("线程池完成数量:" + threadPoolExecutor.getCompletedTaskCount());
                    System.out.println("核心线程数数量:" + threadPoolExecutor.getCorePoolSize());
                    System.out.println("队列数量:" + threadPoolExecutor.getQueue().size());
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("-------------------------------------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threadPoolExecutor.execute(command);

        }

        threadPoolExecutor.shutdown();

    }

    static class TestThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        TestThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "测试线程池-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
