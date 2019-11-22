package com.sunhome.framework.desgin.pattern.base.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizongren
 * @date 2019.11.22 9:21
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> persons = new ArrayList<>();
        for (Person p : personList) {
        if (p.getGender().equals("Female")){
            persons.add(p);
        }
        }

        return persons;
    }
}
