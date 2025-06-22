package com.batiaev.java3.lesson1;

public class ObjectManager {
    private Object value;

    public ObjectManager(Object value) {
        this.value = value;
    }

    public void print() {
        System.out.println(value.toString());
    }
    public Object getValue() {
        return value;
    }

    public static void main(String[] args) {
        ObjectManager manager = new ObjectManager(15);
        int intValue = (int) manager.getValue();

        ObjectManager manager2 = new ObjectManager("Hello world");
        Object string = manager2.getValue();
        intValue = (Integer)string;
        System.out.println();

    }
}
