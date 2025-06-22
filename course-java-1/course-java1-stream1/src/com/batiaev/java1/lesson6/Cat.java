package com.batiaev.java1.lesson6;

/**
 * Cat
 *
 * @author anton
 * @since 21/12/17
 */
public class Cat extends Animal {
    private int countOfChilds = 0;

    public Cat(String name) {
        this(name, 0);
        this.countOfChilds = 1;
        System.out.println("Cat(name)");
    }

    public Cat(String name, int age) {
        super(name, age);
        System.out.println("Cat(name, age)");
    }

    @Override
    public String makeSound() {
        return "meow";
    }

    public void play() {
        System.out.println(name + " playing...");
    }

    @Override
    public boolean canFly() {
        System.out.println("So sorry, but cat cannot fly");
        return super.canFly();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
