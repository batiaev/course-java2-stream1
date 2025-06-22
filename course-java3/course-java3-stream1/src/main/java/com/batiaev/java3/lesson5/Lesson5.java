package com.batiaev.java3.lesson5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Lesson5 {
    public static void main(String[] args) {
        Map<String, Double> value = new HashMap<>();
        Map<String, Double> synchronizedMap = Collections.synchronizedMap(value);
        Map<String, Double> synchronizedMap2 = new ConcurrentHashMap<>();
    }
}
