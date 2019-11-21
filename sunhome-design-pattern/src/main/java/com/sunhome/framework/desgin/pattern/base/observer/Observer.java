package com.sunhome.framework.desgin.pattern.base.observer;

/**
 * @author lizongren
 * @date 2019.11.21 9:32
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
