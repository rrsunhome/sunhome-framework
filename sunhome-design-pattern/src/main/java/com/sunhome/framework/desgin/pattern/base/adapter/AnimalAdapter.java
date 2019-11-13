package com.sunhome.framework.desgin.pattern.base.adapter;

public class AnimalAdapter implements Mammal {
    Bird bird;

    public AnimalAdapter(String type) {
        if (type.equalsIgnoreCase("bird")) {
            bird = new Eagle();
        }
    }

    @Override
    public void info(String type, String name) {
        if (type.equalsIgnoreCase("bird")) {
            bird.info(name);
        }
    }
}
