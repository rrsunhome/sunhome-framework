package com.sunhome.framework.desgin.pattern.base.filter;

import java.util.List;

public interface Criteria {

    List<Person> meetCriteria(List<Person> personList);
}
