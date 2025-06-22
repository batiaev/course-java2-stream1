package com.batiaev.java2.lesson5;

public class Lesson5 {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(Lesson5::process);
//        thread.setName("My custom thread");
//        thread.setPriority(7);
//        thread.start();
//        thread.join();
//        Thread.State state = thread.getState();
//        process();

        Lesson5 lesson5 = new Lesson5();

        for (int i = 0; i < 1000; i++) {
            lesson5.example2(true);
        }
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lesson5.example2(false);
            }
        }).start();
    }

    private static void process() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized void example1() {
        //FIXME
    }

    private volatile static long counter = 0;

    private synchronized void example2(boolean increase) {
        if (increase)
            counter += 2;
        else
            counter -= 1;
        System.out.println("Cur value = " + counter);
    }

    private synchronized void example22() {
        //FIXME
    }

    private void example3() {
        Object monitor = new Object();
        Object monitor2 = new Object();
        synchronized (monitor) {
            //FIXME
        }
        synchronized (monitor2) {
            //FIXME
        }
    }
}
