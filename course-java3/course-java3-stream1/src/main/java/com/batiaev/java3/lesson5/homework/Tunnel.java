package com.batiaev.java3.lesson5.homework;

import java.util.concurrent.Semaphore;

import static com.batiaev.java3.lesson5.homework.Race.log;

public class Tunnel extends Stage {
    private static final int CARS_MAX = Race.CARS_COUNT / 2;
    private Semaphore semaphore = new Semaphore(CARS_MAX);

    Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                log(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                log(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
