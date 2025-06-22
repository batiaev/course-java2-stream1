package com.batiaev.java3.lesson5.homework;

import java.util.concurrent.Semaphore;

import static com.batiaev.java3.lesson5.homework.LogUtil.log;

public class Tunnel extends Road {
    private Semaphore semaphore;

    Tunnel(int limit) {
        super(80);
        semaphore = new Semaphore(limit);
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            log(c.getName() + " готовится к этапу(ждет): " + description);
            semaphore.acquire();
            super.go(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
