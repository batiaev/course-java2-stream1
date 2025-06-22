package com.batiaev.java1.lesson6;

/**
 * Dog
 *
 * @author anton
 * @since 22/03/18
 */
public class Dog extends Animal {
    public Dog() {
        this("dog", "white", 0);
    }

    public Dog(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String getSound() {
        return "gaw";
    }

//    @Override
//    public void test() {
//        System.out.println("Dog test");
//    }
}
