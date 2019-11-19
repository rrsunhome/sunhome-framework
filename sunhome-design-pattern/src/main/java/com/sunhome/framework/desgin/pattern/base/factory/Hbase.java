package com.sunhome.framework.desgin.pattern.base.factory;

public class Hbase implements DataBase{


    @Override
    public void create() {
        System.out.println("Hbase create");
    }
}
