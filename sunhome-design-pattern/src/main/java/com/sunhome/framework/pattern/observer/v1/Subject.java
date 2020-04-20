package com.sunhome.framework.pattern.observer.v1;

public interface Subject {

    void register(Observer observer);

    void remove(Observer observer);

    void notify(String message);


}
