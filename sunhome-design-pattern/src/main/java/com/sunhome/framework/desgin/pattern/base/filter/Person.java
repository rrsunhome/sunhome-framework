package com.sunhome.framework.desgin.pattern.base.filter;

import lombok.Getter;

/**
 * @author lizongren
 * @date 2019.11.22 9:07
 */
@Getter
public class Person {

    private String name;
    private String maritalStatus;
    private String gender;



    public Person(String name, String maritalStatus, String gender) {
        this.name = name;
        this.maritalStatus = maritalStatus;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
