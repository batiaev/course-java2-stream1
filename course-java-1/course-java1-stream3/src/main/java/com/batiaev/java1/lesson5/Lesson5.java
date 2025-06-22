package com.batiaev.java1.lesson5;

import java.util.Scanner;

/**
 * Lesson5
 *
 * @author anton
 * @since 19/03/18
 */
public class Lesson5 {

    public static void main(String[] args) {
        String name = new String("Anton");
        Scanner scanner = new Scanner(System.in);

        CatOld barsik = CatOld.create("Barsik");
//        CatOld barsik = new CatOld("Barsik");
//        barsik.color = "blue";
//        barsik.setAge(3);
//        barsik.setColor("black");

        CatOld murzik = new CatOld("Murzik", "white", 3);
//        CatOld murzik2 = new CatOld("Murzik", "white", 3);
        CatOld murzik4 = new CatOld(murzik.getName(), murzik.getColor(), murzik.getAge());
//        CatOld murzik3 = murzik;
//        if (murzik.equals(murzik2)) {
//            System.out.println("same murzik");
//        } else {
//            System.out.println("not the same");
//        }
    }
}
