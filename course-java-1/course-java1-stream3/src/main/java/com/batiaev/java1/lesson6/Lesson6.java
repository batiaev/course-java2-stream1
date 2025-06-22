package com.batiaev.java1.lesson6;

/**
 * Lesson6
 *
 * @author anton
 * @since 22/03/18
 */
public class Lesson6 {
    public static void main(String[] args) {
        Horse horse = new Horse();

        Animal[] animals = new Animal[4];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = horse;
        animals[3] = new Animal("", "", 0) {
            @Override
            public String getSound() {
                return "...";
            }
        };

        move(horse);
        makeSomeNoize(horse);

        CanMove[] elements = new CanMove[]{horse, new Robot()};
        for (CanMove element : elements) {
            element.getDistance();
            element.move();
        }
        animals[3].getClass().getSuperclass().getSimpleName();
//        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Horse()};
        for (Animal animal : animals) {
            System.out.format("Animal %s named %s make noize %s"
                    , animal.getClass().getSimpleName()
                    , animal.getName(),
                    animal.getSound());
        }
//        Animal animal = new Cat();
//        System.out.println(animal.getSound());
//        if (animal instanceof Cat) {
//            Cat cat = (Cat) animal;
//            System.out.println(cat.getSound());
//        }
//        System.out.println(animal);
    }

    private static void makeSomeNoize(Animal horse) {
        horse.getSound();
    }

    private static void move(CanMove element) {
        element.move();
    }
}
