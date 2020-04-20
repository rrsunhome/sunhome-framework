package com.sunhome.framework.pattern.observer.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午12:04
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        observers.forEach(x -> x.update(message));
    }

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.register(new ConcreteObserverOne());
        subject.register(new ConcreteObserverTwo());

        subject.notify("234");

    }
}
