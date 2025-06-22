package com.batiaev.java1.lesson5;

/**
 * Lesson5
 *
 * @author anton
 * @since 18/12/17
 */
public class Lesson5 {

    private static Cat createCat() {

        Cat barsik = new Cat(3);

//        barsik.setName("barsik");
        barsik.setName("murzik");
        barsik.setColor("green");
        return barsik;
    }

    public static void main(String[] args) {
        Cat variable1 = createCat();


        Cat variable2 = variable1;
        variable2.setColor("red");
        variable1.setColor("blue");
        variable1 = new Cat(7);


        System.out.println(variable2);
        System.out.println(variable1);


//        Human anton = new Human(1);
//        execute(anton);
//        anton.play(barsik);
        Human ivan = new Human(2);

//        String hello = "hello world";
//        String hey = new String("hey world");
//        System.out.println(hello);
//        System.out.println(hey);
    }

    private static void execute(Human anton) {
        doSomething(anton);
    }

    private static void doSomething(Human anton) {

        if (anton != null)
            anton.play(createCat());
    }
}
