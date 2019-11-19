package com.sunhome.framework.desgin.pattern.base.factory;

public class RedisFactory implements DataBaseFactory {
    @Override
    public DataBase create() {

        return  new Redis();
    }
}
