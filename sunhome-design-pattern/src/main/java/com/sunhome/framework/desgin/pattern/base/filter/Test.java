package com.sunhome.framework.desgin.pattern.base.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizongren
 * @date 2019.11.22 9:35
 */
public class Test {

    public static void main(String[] args) {
        List<Person> persons=new ArrayList<>();
        persons.add(new Person("蛮王","Married","Male"));
        persons.add(new Person("剑圣","Single","Male"));
        persons.add(new Person("艾希","Married","Female"));
        persons.add(new Person("风女","Single","Female"));

        Criteria meal =new CriteriaMale();
        Criteria feMeal =new CriteriaFemale();
        Criteria single =new CriteriaSingle();
        Criteria mealAndSingle =new AndCriteria(meal,single);
        Criteria feMaleOrSingle =new OrCriteria(feMeal,single);


        System.out.println("Male:");
        printPerson(meal.meetCriteria(persons));
        System.out.println("FeMale");
        printPerson(feMeal.meetCriteria(persons));
        System.out.println("maleAndSingle");
        printPerson(mealAndSingle.meetCriteria(persons));
        System.out.println("feMaleOrSingle");
        printPerson(feMaleOrSingle.meetCriteria(persons));



    }




    public static void printPerson(List<Person> personList){
    for (Person p:personList) {
        System.out.println(p.toString());
    }
}
}
