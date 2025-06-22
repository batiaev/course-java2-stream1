package com.batiaev.java2.lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class PhoneBook {
    private Map<String, Set<String>> data = new HashMap<>();

    public void add(String name, String phoneNumber) {
        data.putIfAbsent(name, new HashSet<>());
        data.get(name).add(phoneNumber);
    }

    public Set<String> get(String name) {
        return data.get(name);
    }
}
