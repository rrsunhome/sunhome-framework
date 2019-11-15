package com.sunhome.framework.desgin.pattern.base.decorator;

public class FlyAnimalDecorator extends AnimalDecorator {


    public FlyAnimalDecorator(Animal animal) {
        super(animal);
    }

    @Override
    public void info(String name) {
        animal.info(name);
        fly();
    }
    private void fly(){
        System.out.println("I can fly");
    }
}
