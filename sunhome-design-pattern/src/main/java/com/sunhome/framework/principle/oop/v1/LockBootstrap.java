package com.sunhome.framework.principle.oop.v1;


/**
 * 面对对象的重写特性
 *
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:24
 * @description:
 */
public class LockBootstrap {


    public static void main(String[] args) {

        Lock mockLock = new Lock() {
            @Override
            public boolean lock() {
                return false;
            }
        };

        System.out.println(mockLock.lock());
    }
}
