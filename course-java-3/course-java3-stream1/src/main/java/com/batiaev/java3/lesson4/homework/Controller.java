package com.batiaev.java3.lesson4.homework;

import java.util.Arrays;
import java.util.List;

public class Controller {
    int pos = 0;
    final List<String> list = Arrays.asList("A", "B", "C");

    public String getCurrent() {
        return list.get(pos);
    }

    public void move() {
        pos = (pos == list.size() - 1) ? 0 : pos + 1;
    }
}
