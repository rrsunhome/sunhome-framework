package com.sunhome.framework.desgin.pattern.base.adapter;

public class Eagle implements Bird{
    @Override
    public void info(String name) {
        System.out.println("I can fly, I am "+name);
    }
}
