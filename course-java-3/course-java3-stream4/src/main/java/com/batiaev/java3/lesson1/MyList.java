package com.batiaev.java3.lesson1;

import java.util.Arrays;

/**
 * MyList
 *
 * @author anton
 * @since 19/08/19
 */
public class MyList<MyCustomType> {

    private MyCustomType[] value;
    private int index = 0;

    public void add(MyCustomType v) {
//        value[index] = v;
        index++;
    }

    public MyCustomType get(int idx) {
//        return value[idx];
        return null;//FIXME
    }

    public static <MySecondCustomType>
        MyList<MySecondCustomType> sort(MyList<MySecondCustomType> list) {
        return list;//FIXME
    }

    public MyCustomType[] sort2(MyList<MyCustomType> list) {
        MyCustomType[] array = list.toArray();
        Arrays.sort(array);
        return array;
    }

    private MyCustomType[] toArray() {
        return null;//Fixme
    }
}
