package com.batiaev.java1.lesson7;

/**
 * Lesson7
 *
 * @author anton
 * @since 25/12/17
 */
public class Lesson7 {
    public static void main(String[] args) {

        Cat cat = new Cat(6,"test");
        cat.eat(new Plate(20));


//        String value = "string1" + "spring2";

        long start = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10000; ++i) {
            stringBuffer.append(Math.sqrt(i));
        }
        String s = stringBuffer.toString();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; ++i) {
            stringBuilder.append(Math.sqrt(i));
        }
        s = stringBuilder.toString();
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        String value = new String();
        for (int i = 0; i < 10000; ++i) {
            value = value + String.valueOf(Math.sqrt(i));
        }
        s = value;
        System.out.println(System.currentTimeMillis() - start);

        stringInfo();
    }

    private static void stringInfo() {
        String value = "value";
        if (value.length() > 0) {
            System.out.println(value);
        }
        if (!value.isEmpty()) {
            System.out.println(value);
        }
        char v = value.charAt(0);
        if (value.startsWith("va")) {
            System.out.println("vavava");
        }
        if (value.endsWith("ue")) {
            System.out.println("vavava");
        }
        String name = value.getClass().getName();
        int indexOf = value.indexOf("ue");
        value.replace("a", "o");
        value.split("l");
        value.substring(3, 10);
    }
}
