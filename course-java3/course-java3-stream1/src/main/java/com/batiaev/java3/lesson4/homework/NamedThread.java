package com.batiaev.java3.lesson4.homework;

public class NamedThread extends Thread {
    private String name;
    private Controller controller;

    public NamedThread(String name, Controller controller) {
        setName(name);
        this.controller = controller;
    }

    @Override
    public void run() {
        synchronized (controller) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (!controller.getCurrent().equals(getName())) {
                        controller.wait();
                    }
                    System.out.print(getName());
                    controller.move();
                    controller.notifyAll();
                } catch (Exception e) {
                }
            }
        }
    }
}
