package com.sunhome.framework.pattern.observer.v1;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午12:07
 */
public class ConcreteObserverTwo implements Observer {

    @Override
    public void update(String message) {
        System.out.println("ConcreteObserverTwo" + message);
    }
}
