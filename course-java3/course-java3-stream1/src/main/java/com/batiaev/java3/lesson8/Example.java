package com.batiaev.java3.lesson8;

public class Example implements Test1, Test2 {
    private static int value = 5;

    static {
        System.out.println("static block " + value);
        value = 20;
        System.out.println("static block 2 " + value);
    }

    public Example() {
        value = 50;
        System.out.println("constructor " + value);
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.value = 100;
        Class<Lesson8> lesson8Class = Lesson8.class;
        System.out.println(Lesson8.VALUE);

        System.out.println("main " + example.value);
        throw new OutOfMemoryError();
    }

    @Override
    public void exec() {
        System.out.println("example");
    }
}
