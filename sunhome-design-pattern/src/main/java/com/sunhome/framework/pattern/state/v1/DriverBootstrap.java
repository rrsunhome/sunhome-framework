package com.sunhome.framework.pattern.state.v1;

/**
 * 状态机定义了 状态 事件 行为
 * 在什么状态下通过什么事件触发了那些行为
 *
 * @author : wangqijia
 * create at:  2020/4/7  下午5:49
 */
public class DriverBootstrap {

    public static void main(String[] args) {

        Driver driver = new Driver();

        driver.start();
        driver.start();

        driver.close();


    }
}
