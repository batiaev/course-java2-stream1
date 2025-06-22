package com.batiaev.java3.lesson5.homework;

public class Car extends Thread {
    private static int CARS_COUNT = 0;

    private Race race;
    private int speed;

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        setName("Участник #" + ++CARS_COUNT);
    }

    @Override
    public void run() {
        race.start(getName());
        race.getStages().forEach(stage -> stage.go(this));
        race.finish(getName());
    }
}
