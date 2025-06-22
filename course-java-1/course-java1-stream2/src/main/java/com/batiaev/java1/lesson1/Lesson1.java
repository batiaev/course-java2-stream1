package com.batiaev.java1.lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        calc(args);
    }

    private static void calc(String[] args) {

        int sum = summaNew(5, 10);

        System.out.println("Summa = " + sum);

        String name = "Anton";
        if (true) {
            System.out.print("test");
            System.out.println("test2");
        }

        if (sum > 10 && sum < 100) {
            System.out.println("summa > 10!");
        } else if (sum > 5) {
            System.out.println("summa < 10!");
        } else {
            System.out.println("summa < 10!");
        }

//        int i = 3;
//        i = i + 3 * 14;
//        i -= 4;
//
//        double pi = 3.1415;
//        String name = "Anton";
//        String name2 = new String("Anton");
//
//        char tVariable = 't';
    }

    public static int summaNew(int variable1, int variable2) {
        int sum = variable1 + variable2;
        return sum;
    }
}
