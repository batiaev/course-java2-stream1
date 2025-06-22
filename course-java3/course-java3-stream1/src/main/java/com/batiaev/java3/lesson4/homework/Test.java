package com.batiaev.java3.lesson4.homework;

public class Test {
    public static void main(String[] args) {
        Controller controller = new Controller();
        new NamedThread("A", controller).start();
        new NamedThread("B", controller).start();
        new NamedThread("C", controller).start();
    }
}

