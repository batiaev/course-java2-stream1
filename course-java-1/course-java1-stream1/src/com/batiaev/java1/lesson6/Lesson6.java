package com.batiaev.java1.lesson6;

/**
 * Lesson6
 *
 * @author anton
 * @since 21/12/17
 */
public class Lesson6 {
    public static void main(String[] args) {

        Animal[] animals = new Animal[4];

        Animal a1 = new Cat("name1");
        Animal ivan = new SmartCat("ivan");
        Animal a2 = new Dog("name2");
        Animal a3 = new Horse("name2");

        animals[0] = a1;
        animals[1] = a2;
        animals[2] = a3;
        animals[3] = ivan;

        for (Animal animal : animals) {
            if (animal instanceof Cat)
                ((Cat) animal).play();
            else if (animal instanceof Dog)
                ((Dog) animal).run();
            else
                System.out.println(animal.makeSound());
        }

        System.out.println("---");
        Animal barsik = new Cat("barsik");

        Cat barsik2 = (Cat) barsik;
        barsik2.play();

        System.out.println(barsik.canFly());

        Cat cat = new Cat("murzik");
        cat.play();

        System.out.println(cat.makeSound());

        if (cat.canFly()) {
            System.out.println("flying is unavailable");
        }
        System.out.println(cat);
    }
}
