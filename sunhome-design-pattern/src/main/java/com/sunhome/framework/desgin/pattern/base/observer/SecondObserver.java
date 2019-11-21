package com.sunhome.framework.desgin.pattern.base.observer;

/**
 * @author lizongren
 * @date 2019.11.21 9:36
 */
public class SecondObserver extends Observer{
    public SecondObserver(Subject subject) {
        this.subject=subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("this is Second Observer,state:"+subject.getState());
    }
}
