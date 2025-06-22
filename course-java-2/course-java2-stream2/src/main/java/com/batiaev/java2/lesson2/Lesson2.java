package com.batiaev.java2.lesson2;

import java.io.File;
import java.io.IOException;

/**
 * Something about Exception:
 * 1) Throwable(checked)
 * 2) Exception(checked) & Error(unchecked)
 * 3) RuntimeException(unchecked)
 */
public class Lesson2 {
    public static void main(String[] args) {
            example4();
    }

    private static void example4() {
        try (
             AutoCloseable closeable2 = new Resource();
             AutoCloseable closeable3 = new Resource()
            ) {

            System.out.println(closeable2);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }

    static class Resource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("close AutoCloseable");
        }
    }

    private static int example3() {
        AutoCloseable closeable1 = new Resource();

        AutoCloseable closeable = new AutoCloseable() {
            public void close() {
                System.out.println("close AutoCloseable");
            }
        };

        System.out.println("open resource");
        try {
            System.out.println("process resource");
            example1();
            return 3;
        } catch (IOException e) {
            System.out.println("resource exception");
            return 2;
        } catch (RuntimeException e) {
            System.out.println("resource RuntimeException");
            return 5;
        } finally {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("close resource");
//            return 1;
        }
    }

    private static void example2() {
        ArithmeticException exception = new ArithmeticException("/ by zero");
//        throw exception;
        throw new CustomException("something happend", exception);
//        throw new OutOfMemoryError();
//        long value = 10/0;
    }

    private static void example1() throws IOException {
//        File file = new File("test.txt");
//        boolean b = file.canRead();
//        file.createNewFile();
//        System.out.println(b);
        throw new IOException("custom message");
    }
}
