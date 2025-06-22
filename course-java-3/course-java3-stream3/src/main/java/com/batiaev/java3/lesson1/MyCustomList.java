package com.batiaev.java3.lesson1;

import java.util.ArrayList;
import java.util.List;

//public class MyCustomList
//        <T extends HasInfo & Serializable & Externalizable & List,
//                TYPE1 extends Serializable,
//                TYPE2,
//                MyBestCustomType> {
public class MyCustomList<T extends HasInfo> {
    private T[] values;

    T get(int index) {
        T value = values[index];
//        ((Comparable<T>)value).compareTo();
        return value;
    }

    String getInfo(int index) {
        T value = values[index];
        return value.getInfo();
    }

    void add(int index, T value) {
        values[index] = value;
    }


    void testMethod(List<? super Integer> list) {

        List<? extends Number> data1 = new ArrayList<>();
//        data1.add(new Integer(1));
        data1.add(null);
        Number number = data1.get(1);
        List<? super Integer> data2 = new ArrayList<>();
        data2.add(1);
//        data2.add(new Number());

//        list.add();
    }

    <TYPE2> TYPE2 get2(TYPE2 value) {
        return value;
    }
}
