package com.sunhome.framework.pattern.singleton.v3;

import com.sunhome.framework.pattern.singleton.ConcurrentIdGenerator;
import com.sunhome.framework.pattern.singleton.IdCallback;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午12:57
 * @description:
 */
public class IdGeneratorBootstrap {

    public static void main(String[] args) {
        ConcurrentIdGenerator concurrentIdGenerator = new ConcurrentIdGenerator();


        for (int i = 0; i < 10; i++) {
            concurrentIdGenerator.execute(new IdCallback() {
                @Override
                public void doHandle() {
                    System.out.println(IdGenerator.getInstance().getId());
                }
            });
        }

    }
}
