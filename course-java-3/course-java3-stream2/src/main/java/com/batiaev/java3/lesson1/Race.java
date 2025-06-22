package com.batiaev.java3.lesson1;

import java.io.Serializable;
import java.util.*;

public class Race<T extends Animal & Serializable,
        S extends Swimmable, D extends HasCar> {
    private List<T> animals;
    private T firstAnimal;
    private Set<S> swimmableAnimals;

    public Race(List<T> animals) {
        this.animals = animals;
    }

    public void swim(S value) {
        value.swim();
    }

    public T getFirtsSwimmer() {
        return firstAnimal;
    }

    public void print(List<T> players) {
        for (T player : players) {
            System.out.println(player);
        }
    }

    public void printInfo(List<?> players) {
        for (Object player : players) {
            System.out.println(player);
        }
    }

    public void drive(D value) {
        value.drive();
    }

    void startRace() {
        for (T people : animals) {
            if (people instanceof Swimmable)
                ((Swimmable) people).swim();
            if (people instanceof HasCar)
                ((HasCar) people).drive();
        }
    }

    public static Map f(Map val) {
        val.put("asd", "asd");
        return val;
    }

    public static void main(String[] args) {
        Map<String,Integer> data = new HashMap<>();
        data.put("value", 123);
        data  = f(data);

        Integer asd = data.get("asd");
        System.out.println(asd);
        Integer da = data.get("da");


//        Race<? extends Animal, Swimmable, HasCar, HasCar> race
//                = new Race<>(new ArrayList<>());


//        List<String> stringData = new ArrayList<>();
//        race.printInfo(stringData);
    }
}
