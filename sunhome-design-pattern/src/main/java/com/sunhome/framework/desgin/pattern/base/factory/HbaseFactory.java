package com.sunhome.framework.desgin.pattern.base.factory;

public class HbaseFactory implements DataBaseFactory{

    @Override
    public DataBase create() {
        return new Hbase() ;
    }
}
