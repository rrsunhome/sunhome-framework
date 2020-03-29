package com.sunhome.framework.pattern.proxy.v1;

import java.util.concurrent.TimeUnit;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午7:34
 * @description:
 */
public class UserService implements IUserService {


    @Override
    public void login() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("login success");
    }
}
