package com.batiaev.java3.lesson4.homework;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private int pos = 0;
    private static int COUNT = 5;
    private final static List<String> list = Arrays.asList("A", "B", "C");

    public String getCurrent() {
        return list.get(pos);
    }

    public void move() {
        pos = (pos == list.size() - 1) ? 0 : pos + 1;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        list.forEach(symbol -> new NamedThread(symbol, COUNT, controller).start());
    }

}
