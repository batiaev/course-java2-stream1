package com.batiaev.java1.lesson7;

/**
 * Lesson7
 *
 * @author anton
 * @since 26/03/18
 */
public class Lesson7 {
    public static void main(String[] args) {
        //FIXME
        String name = "Anton";
        String lastname= "Anton";
        String value2= "Anton";

        name.contains("");
        name.endsWith("");
        name.startsWith("");
        boolean empty = name.isEmpty();
        boolean b = name.length() == 0;
        String lastName = "Batiaev";
        String fullName = name + " " + lastName;
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("test");
//        stringBuilder.toString();

        long now = System.currentTimeMillis();
        String value = "";
        for (int i = 0; i < 100000; i++) {
            value += i;
        }
        System.out.println("time= " + (System.currentTimeMillis() - now) + " " + value.length());
        now = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        System.out.println("time= " + (System.currentTimeMillis() - now) + " " + stringBuilder.toString().length());
    }
}
