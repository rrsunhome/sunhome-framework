package com.sunhome.framework.desgin.pattern.base.decorator;

public abstract class AnimalDecorator implements Animal {
    protected Animal animal;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }

    public void info(String name) {
        animal.info(name);
    }
}
