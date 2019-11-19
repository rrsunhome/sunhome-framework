package com.sunhome.framework.desgin.pattern.base.factory;

public class Test {
    public static void main(String[] args) {
        DataBaseFactory dataBaseFactory=new HbaseFactory();
        DataBase dataBase = dataBaseFactory.create();
        dataBase.create();
    }
}
