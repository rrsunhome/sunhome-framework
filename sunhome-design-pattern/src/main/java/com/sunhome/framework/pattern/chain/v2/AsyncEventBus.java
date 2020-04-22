package com.sunhome.framework.pattern.chain.v2;

import lombok.SneakyThrows;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangqijia
 * create at:  2020/4/22  上午12:00
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }



}
