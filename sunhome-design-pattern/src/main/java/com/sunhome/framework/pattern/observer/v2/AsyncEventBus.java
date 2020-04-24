package com.sunhome.framework.pattern.observer.v2;

import java.util.concurrent.Executor;

/**
 * @author : wangqijia
 * create at:  2020/4/22  上午12:00
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }



}
