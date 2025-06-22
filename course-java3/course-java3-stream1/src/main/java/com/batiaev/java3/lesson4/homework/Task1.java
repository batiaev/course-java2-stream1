package com.batiaev.java3.lesson4.homework;

public class Task1 {

    public static void main(String[] args) {
        Controller controller = new Controller();
        new NamedThread("B", controller).start();
        new NamedThread("C", controller).start();
        new NamedThread("A", controller).start();
    }

}
