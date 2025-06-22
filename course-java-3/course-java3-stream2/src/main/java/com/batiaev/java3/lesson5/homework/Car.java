package com.batiaev.java3.lesson5.homework;

import java.util.concurrent.BrokenBarrierException;

import static com.batiaev.java3.lesson5.homework.Race.*;

public class Car extends Thread {
    private static int CARS_COUNT = 0;

    private Race race;
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        setName("Участник #" + CARS_COUNT);
    }

    @Override
    public void run() {
        try {
            log(getName() + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            log(getName() + " готов");
            START.countDown();
            START.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        race.getStages().forEach(stage -> stage.go(this));

        synchronized (WINNER_MONITOR) {
            int position = results.incrementAndGet();
            log(position == 1 ? getName() + " - WIN" : getName() + " - занял " + position + " место");
        }
        try {
            FINISH.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
