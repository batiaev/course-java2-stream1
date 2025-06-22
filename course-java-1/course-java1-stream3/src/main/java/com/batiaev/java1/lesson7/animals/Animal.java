package com.batiaev.java1.lesson7.animals;

import com.batiaev.java1.lesson7.equipment.Plate;

import java.awt.event.ActionListener;

/**
 * Animal
 *
 * @author anton
 * @since 26/03/18
 */
public abstract class Animal {
    private String name;
    protected double maxDistance;
    protected double maxSwim;
    protected double maxJump;

    protected double appetite;
    protected boolean full;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public double getAppetite() {
        return appetite;
    }

    public void setAppetite(double appetite) {
        this.appetite = appetite;
    }

    public static void main(String[] args) {
        Cat[] cats = new Cat[2];
        cats[0] = new Cat("Murzik");
        cats[0].setAppetite(10);
        cats[1] = new Cat("Barsik");
        cats[1].setAppetite(7);
        Plate plate = new Plate(50);
        for (Cat cat : cats) {
            cat.eat(plate);
            if (cat.isFull()) {
                System.out.println("Cat " + cat.getName() + " is full!");
            }
        }
    }

//    public static void main(String[] args) {
//
////        int appetite = 20;
////        System.out.println(appetite);
////        change(appetite);
////        System.out.println(appetite);
////        appetite = change2(appetite);
////        System.out.println(appetite);
//
//        ///
//
//
//        Cat cat = new Cat(1,1);
//        cat.setName("Murzik");
//
//        System.out.println(cat.getName());
//        changeCat(cat);
//        System.out.println(cat.getName());
//        changeCat2(cat);
//        System.out.println(cat.getName());
//
//
//        ///
//
//
//        int dispersion = 0;//appetite;
//        Dog dog = new Dog(dispersion);
//        dog.setAppetite(5);
//        Plate plate = new Plate(50);
//        System.out.println(plate.getAmountOfFood());
//        boolean eat = dog.eat(plate);
//        System.out.println(plate.getAmountOfFood());
//        System.out.println(eat);
////        Animal[] animals = new Animal[2];
////        animals[0] = new Dog(150);
////        animals[0] = new Cat(5, 20);
////        for (Animal animal : animals) {
////            animal.jump(10);
////            animal.swim(5);
////            animal.run(15);
////        }
//    }

    private static void changeCat2(Cat cat) {
        cat = new Cat(2, 2);
        cat.setName("new Cat2");
    }

    private static void changeCat(Cat cat) {
        cat.setName("Barsik");
    }

    private static int change2(int value) {
        value += 15;
        return value;
    }

    private static void change(int value) {
        value += 15;
        System.out.println("from change" + value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getMaxSwim() {
        return maxSwim;
    }

    public void setMaxSwim(double maxSwim) {
        this.maxSwim = maxSwim;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public Animal(double swim, double jump, double run) {
        if (swim < 0) swim = 0;
        if (jump < 0) jump = 0;
        if (run < 0) run = 0;
        this.maxDistance = run;
        this.maxJump = jump;
        this.maxSwim = swim;
    }

    protected abstract boolean swim(double value);

    protected abstract boolean run(double value);

    protected abstract boolean jump(double value);

    protected boolean eat(Plate plate) {
        if (plate.getAmountOfFood() < appetite)
            return false;
        plate.descreaseFood(appetite);
        setFull(true);
        return full;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{");
        sb.append("name=").append(name);
        sb.append(", maxDistance=").append(maxDistance);
        sb.append(", maxSwim=").append(maxSwim);
        sb.append(", maxJump=").append(maxJump);
        sb.append('}');
        return sb.toString();
    }
}
