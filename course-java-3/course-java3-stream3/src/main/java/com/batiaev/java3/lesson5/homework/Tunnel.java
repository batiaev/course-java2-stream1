package com.batiaev.java3.lesson5.homework;

import java.util.concurrent.Semaphore;

import static com.batiaev.java3.lesson5.homework.LogUtil.log;

public class Tunnel extends Stage {
    private Semaphore semaphore;

    Tunnel(int limit) {
        semaphore = new Semaphore(limit);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
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
    }
}
