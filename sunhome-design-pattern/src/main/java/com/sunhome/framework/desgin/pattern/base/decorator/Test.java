package com.sunhome.framework.desgin.pattern.base.decorator;
/*
* 装饰器模式
* 为祁家添加飞的功能
* */
public class Test {
    public static void main(String[] args) {
        Animal people = new People();
        people.info("wangqijia");

        AnimalDecorator flyAnimalDecorator = new FlyAnimalDecorator(new People());
        flyAnimalDecorator.info("wangqijia");
    }
}
