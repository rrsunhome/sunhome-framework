package com.sunhome.framework.thread.concurrent.queue;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 使用优先级队列实现的无界阻塞队列
 * 可以实现延迟获取
 */
public class DelayQueueTest {

    private static DelayQueue<Order> orderDelayQueue = new DelayQueue<>();

    public static void main(String[] args) {

        /**
         * 模拟创建1个订单，判断订单是否支付，轮询最大次数为五次
         */
        Order order = new Order(new Date(), 5);
        orderDelayQueue.add(order);

        new Thread(() -> {
            while (true) {
                try {
                    Order task = orderDelayQueue.take();
                    task.run();
                    // 删除
                    orderDelayQueue.remove(task);

                    if (task.getExecutionMaxCount() > 0) {
                        orderDelayQueue.put(new Order(task.getLastExecutionTime(), task.getExecutionMaxCount()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}

@Data
class Order implements Delayed, Runnable {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private long executionTime;
    /**
     * 最后执行时间
     */
    private Date lastExecutionTime;
    /**
     * 执行最大次数
     */
    private int executionMaxCount;
    /**
     * 订单状态
     */
    private int status;

    public Order(Date lastExecutionTime, int executionMaxCount) {

        this.executionTime = (2 * 1000) + lastExecutionTime.getTime();

        this.executionMaxCount = executionMaxCount;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // System.out.println(unit.convert(this.executionTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
        return unit.convert(this.executionTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Order task = (Order) o;
        // 默认升序
        return executionTime > task.executionTime ? 1 : (executionTime < task.executionTime ? -1 : 0);
    }

    @Override
    public void run() {
        this.lastExecutionTime = new Date();
        this.executionMaxCount = this.executionMaxCount - 1;
        System.out.println("currentTime:" + LocalDateTime.now().format(dtf));
    }
}




