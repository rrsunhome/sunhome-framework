package com.sunhome.framework.thread.concurrent.queue;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * fork join 框架
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        countTask task = new countTask(0, 5);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);

        System.out.println(forkJoinTask.isCompletedAbnormally());
        if (forkJoinTask.isCompletedAbnormally()) {
            System.out.println("error" + forkJoinTask.getException());
        }
    }


}

@AllArgsConstructor
class countTask extends RecursiveTask<Integer> {

    private int start;

    private int end;

    @Override
    protected Integer compute() {

        if (true) {
            throw new RuntimeException("error");
        }

//        int sum = 0;
//        if (end - start > 2) {
//            for (int i = start; i < end; i++) {
//                sum += i;
//            }
//        } else {
//            int middle = (start + end) / 5;
//
//            countTask leftTask = new countTask(start, middle);
//
//            countTask rightTask = new countTask(start, middle + 1);
//
//            leftTask.fork();
//            rightTask.fork();
//
//            sum = leftTask.join() + rightTask.join();
//
//
//        }
        return 0;
    }
}