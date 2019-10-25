package com.sunhome.framework.thread.concurrent.queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 使用优先级队列实现的无界阻塞队列
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {

        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        priorityBlockingQueue.add(new People("小李", 10));

        priorityBlockingQueue.add(new People("小李1", 12));

        priorityBlockingQueue.add(new People("小李2", 11));

        try {
            System.out.println(priorityBlockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class People implements Comparable<People> {

        private String name;
        private int age;

        @Override
        public int compareTo(People o) {
            if (this.age > o.getAge()) {
                return -1;
            } else if (this.age < o.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }
    }


}
