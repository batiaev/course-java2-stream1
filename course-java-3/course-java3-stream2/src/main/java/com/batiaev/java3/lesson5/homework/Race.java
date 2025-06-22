package com.batiaev.java3.lesson5.homework;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    static final Object WINNER_MONITOR = new Object();
    static final Lock WINNER_LOCK = new ReentrantLock();
    private List<Stage> stages;

    List<Stage> getStages() {
        return stages;
    }

    private Race(Stage... stages) {
        this.stages = Arrays.asList(stages);
    }

    static final int CARS_COUNT = 4;
    static final CountDownLatch START = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier FINISH = new CyclicBarrier(CARS_COUNT, () ->
            log("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"));
    static AtomicInteger results = new AtomicInteger(0);

    public static void main(String[] args) {

        log("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        for (int i = 0; i < CARS_COUNT; i++) {
            new Car(race, 20 + (int) (Math.random() * 10)).start();
        }
        try {
            START.await();
            log("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void log(String msg) {
        System.out.format("[%s] %s%n", LocalTime.now(), msg);
    }
}
