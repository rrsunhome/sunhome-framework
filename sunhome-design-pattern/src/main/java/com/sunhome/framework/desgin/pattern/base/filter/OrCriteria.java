package com.sunhome.framework.desgin.pattern.base.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizongren
 * @date 2019.11.22 9:21
 */
public class OrCriteria implements Criteria {

    Criteria criteria;
    Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> persons = criteria.meetCriteria(personList);
        List<Person> otherPersons = otherCriteria.meetCriteria(personList);
        persons.addAll(otherPersons);
        List<Person> collect = persons.stream().distinct().collect(Collectors.toList());
        return collect;
    }
}
