package com.sunhome.framework.desgin.pattern.base.factory;

public class Redis implements DataBase {
    @Override
    public void create() {
        System.out.println("Redis create");
    }
}
