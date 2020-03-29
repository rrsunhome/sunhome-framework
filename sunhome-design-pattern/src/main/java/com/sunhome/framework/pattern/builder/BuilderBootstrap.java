package com.sunhome.framework.pattern.builder;

/**
 * 建造者模式：可以在初始化对象时校验必填项，解决了构造参数过多的问题
 * @author : qijia.wang
 * create at:  2020/3/29
 * @description:
 */
public class BuilderBootstrap {


    public static void main(String[] args) {

        PaymentDTO build = new PaymentDTO.Builder()
                .setBankNo("3")
                .setMoney(23)
                .build();

    }
}
