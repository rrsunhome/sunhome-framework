package com.sunhome.framework.desgin.pattern.base.adapter;

public class People implements Mammal {
    AnimalAdapter animalAdapter;

    @Override
    public void info(String type, String name) {
        if (type.equalsIgnoreCase("bird") ) {
            animalAdapter = new AnimalAdapter(type);
            animalAdapter.info(type,name);
        }else if (type.equalsIgnoreCase("people")){
            System.out.println("I can knock code ,I am "+name);
        }else{
            System.out.println("sorry! "+name);

        }
    }
}
