package com.sunhome.framework.thread.concurrent.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args) {

        AtomicReference atomicReference = new AtomicReference();
        User user = new User(10, "1");
        atomicReference.set(user);

        atomicReference.compareAndSet(user, new User(15, "1212"));

        System.out.println(atomicReference.get());


    }

    @Data
    @AllArgsConstructor
    @ToString
    static class User {

        private int age;

        private String name;

    }


}
