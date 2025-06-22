package com.batiaev.java3.lesson7.homework;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * TestComparator
 *
 * @author anton
 * @since 12/09/19
 */
public class TestComparator implements Comparator<Method> {
    @Override
    public int compare(Method m1, Method m2) {
        final Test annotation1 = m1.getAnnotation(Test.class);
        if (annotation1 == null)
            return 1;
        Integer priority1 = annotation1.priority();
        final Test annotation2 = m2.getAnnotation(Test.class);
        if (annotation2 == null)
            return 0;
        Integer priority2 = annotation2.priority();
        int priorityCompareResult = priority1.compareTo(priority2);
        if (priorityCompareResult == 0) {
            return m1.getName().compareTo(m2.getName());
        }
        return priorityCompareResult;
    }
}
