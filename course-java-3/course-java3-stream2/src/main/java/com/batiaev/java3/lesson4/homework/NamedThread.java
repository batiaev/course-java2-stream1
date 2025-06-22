package com.batiaev.java3.lesson4.homework;

public class NamedThread extends Thread {
    private final Controller monitor;
    private final int count;

    public NamedThread(String name, int count, Controller monitor) {
        setName(name);
        this.monitor = monitor;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (int i = 0; i < count; i++) {
                try {
                    while (!monitor.getCurrent().equals(getName())) {
                        monitor.wait();
                    }
                    System.out.print(getName());
                    monitor.move();
                    monitor.notifyAll();

//                    System.out.println("Step "+ i);
                } catch (Exception e) {
                }
            }
        }
    }
}
