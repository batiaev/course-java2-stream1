package com.batiaev.java2.lesson5;

/**
 * Lesson5
 *
 * @author anton
 * @since 30/10/17
 */
public class Lesson5 {
    static class MyRunnableClass implements Runnable {
        private String name;

        public MyRunnableClass(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("new " + name + " : " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnableClass("thread 1"));
        thread.setPriority(8);
        new Thread(new MyRunnableClass("thread 2")).start();
    }
}
