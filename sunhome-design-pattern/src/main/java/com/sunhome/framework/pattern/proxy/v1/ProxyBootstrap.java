package com.sunhome.framework.pattern.proxy.v1;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午7:42
 * @description:
 */
public class ProxyBootstrap {

    public static void main(String[] args) {

        MetricsProxy proxy = new MetricsProxy();

        IUserService userService = (IUserService) proxy.createProxy(new UserService());


        userService.login();

    }
}
