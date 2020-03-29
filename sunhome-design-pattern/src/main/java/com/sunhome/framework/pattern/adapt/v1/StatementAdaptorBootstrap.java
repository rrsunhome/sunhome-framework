package com.sunhome.framework.pattern.adapt.v1;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午8:15
 * @description:
 */
public class StatementAdaptorBootstrap {

    public static void main(String[] args) {

        StatementService statementService = new StatementServiceImpl();

        statementService.query(new StatementParam());
    }
}
