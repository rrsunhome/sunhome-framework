package com.sunhome.framework.pattern.chain.v2;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author : wangqijia
 * create at:  2020/4/22  上午12:00
 */
public class EventBus {

    private ObserverRegistry observerRegistry = new ObserverRegistry();

    private Executor executor;


    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object observer) {
        observerRegistry.register(observer);
    }

    public void unregister(Object observer) {
        observerRegistry.unregister(observer);
    }

    public void post(Object event) {
        List<ObserverAction> matchedObservers = observerRegistry.getMatchedObservers(event);
        for (ObserverAction matchedObserver : matchedObservers) {
            if (executor != null) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        matchedObserver.execute(event);
                    }
                });
            } else {
                matchedObserver.execute(event);
            }

        }
    }

}
