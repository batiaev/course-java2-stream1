package com.batiaev.java1.lesson6;

import com.batiaev.java1.lesson5.animals.Animal;
import com.batiaev.java1.lesson5.animals.Cat;

/**
 * Lesson6
 *
 * @author anton
 * @since 08/02/18
 */
public class Lesson6 {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[5];
        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = new Dog();
            dogs[i].makeSound();
        }

        Animal[] animals = new Animal[5];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Dog();
        animals[3] = new Cat();
        animals[4] = new Horse();

        CanRun[] dogList = new CanRun[2];
        dogList[0] = (Dog) animals[0];
        dogList[0] = (Dog) animals[2];

        for (Animal animal : animals) {
            animal.printName();
            if (animal instanceof Dog) {
                Dog dog = ((Dog) animal);
                Animal dogLink = animal;
                Dog dogLink2 = dog;
                dog.runDistance();

//                ((Dog) animal).runDistance();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println("Jump :" + cat.getMaxJump());
            }
        }
    }
}
