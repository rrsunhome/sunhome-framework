package com.sunhome.framework.pattern.template.v1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : qijia.wang
 * create at:  2020/3/28  下午5:34
 * @description:
 */
public class MessageQueueLogger extends Logger {

    private static final int DEFAULT_QUEUE_SIZE = 10;

    private ArrayBlockingQueue arrayBlockingQueue;

    private MessageQueueClient messageQueueClient;

    private MessageFormatter messageFormatter;

    private ScheduledExecutorService scheduledExecutorService;

    public MessageQueueLogger(String name, boolean enabled, Level minLevel) {
        super(name, enabled, minLevel);
        arrayBlockingQueue = new ArrayBlockingQueue(DEFAULT_QUEUE_SIZE);
        messageFormatter = new JsonMessageFormatter();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        messageQueueClient = new MessageQueueClient() {
            @Override
            public void send(String message, Level level) {
                try {
                    arrayBlockingQueue.put(messageFormatter.format(message, level));
                } catch (InterruptedException e) {
                    System.out.println("send error");
                }
            }
        };
        queueListener();

    }


    @Override
    protected void doLog(String message, Level level) {
        messageQueueClient.send(message, level);

    }


    private void queueListener() {
        scheduledExecutorService.scheduleWithFixedDelay(
                new QueueTask(arrayBlockingQueue),
                5,
                5,
                TimeUnit.SECONDS);
    }

    public class QueueTask implements Runnable {

        private ArrayBlockingQueue arrayBlockingQueue;

        public QueueTask(ArrayBlockingQueue arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            Object value = arrayBlockingQueue.poll();
            if (value != null) {
                System.out.printf("处理消息: %s \n", value);
            }
        }
    }


    public interface MessageQueueClient {

        void send(String message, Level level);
    }

}
