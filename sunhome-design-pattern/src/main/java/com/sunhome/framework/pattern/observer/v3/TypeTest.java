package com.sunhome.framework.pattern.observer.v3;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author : wangqijia
 * create at:  2020/4/23  上午12:03
 */
public class TypeTest {
    public static void main(String[] args) {
        Set<Class<? super SubEvent>> classes = TypeToken.of(SubEvent.class).getTypes().rawTypes();
        int index = 0;
        for (Class<? super SubEvent> event : classes) {
            Method[] declaredMethods = event.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(index + declaredMethod.getName());
            }
            index++;

        }

    }
}
