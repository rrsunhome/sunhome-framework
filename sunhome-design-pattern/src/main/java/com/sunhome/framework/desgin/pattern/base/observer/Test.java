package com.sunhome.framework.desgin.pattern.base.observer;

/**
 * @author lizongren
 * @date 2019.11.21 9:40
 */
public class Test {
    public static void main(String[] args) {
        Subject subject=new Subject();
        new FirstObserver(subject);
        new SecondObserver(subject);


        System.out.println("state change 10");
        subject.setState(10);
        System.out.println("state change 20");
        subject.setState(20);
    }
}
