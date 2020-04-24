package com.sunhome.framework.pattern.observer.v2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : wangqijia
 * create at:  2020/4/21  下午11:18
 */
public class ObserverAction {

    private Object target;

    private Method method;


    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
