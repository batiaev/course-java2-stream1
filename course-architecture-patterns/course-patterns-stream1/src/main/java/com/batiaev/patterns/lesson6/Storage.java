package com.batiaev.patterns.lesson6;

import java.util.Map;

public class Storage {
    private PersonMapper personMapper;
    private Map<Long, Person> personMap;

    public Person getPerson(long personId) {
        Person person = personMap.get(personId);
        return person == null ? personMapper.getById(personId) : person;
    }
}
