package com.sunhome.framework.desgin.pattern.base.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizongren
 * @date 2019.11.22 9:21
 */
public class AndCriteria implements Criteria {

    Criteria criteria;
    Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstPersons = criteria.meetCriteria(personList);
        return otherCriteria.meetCriteria(firstPersons);
    }
}
