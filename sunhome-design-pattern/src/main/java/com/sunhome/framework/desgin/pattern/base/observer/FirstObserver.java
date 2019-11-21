package com.sunhome.framework.desgin.pattern.base.observer;

/**
 * @author lizongren
 * @date 2019.11.21 9:36
 */
public class FirstObserver extends Observer{
    public FirstObserver(Subject subject) {
        this.subject=subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("this is first Observer,state:"+subject.getState());
    }
}
