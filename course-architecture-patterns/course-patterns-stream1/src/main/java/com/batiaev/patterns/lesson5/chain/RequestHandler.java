package com.batiaev.patterns.lesson5.chain;

import com.batiaev.patterns.lesson5.chain.AbstractHandler;

import java.util.Random;

public class RequestHandler extends AbstractHandler {
    private final String name;
    private volatile boolean busy;

    public RequestHandler(String s) {
        this.name = s;
    }

    @Override
    public void handle() {
        if (new Random().nextBoolean()) {
            System.out.println("AbstractHandler " + name + " is busy..Try another one.");
            super.handle();
        } else {
            busy = true;
            System.out.println("Process request by " + name + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            busy = false;
        }
    }
}
