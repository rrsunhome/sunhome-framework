package com.sunhome.framework.desgin.pattern.base.decorator;

public class People implements Animal {
    @Override
    public void info(String name) {
        System.out.println("I am "+name);
    }
}
