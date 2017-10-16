package com.batiaev.java2.lesson1;

import com.batiaev.java2.lesson1.animal.*;
import com.batiaev.java2.lesson1.obstacle.Cross;
import com.batiaev.java2.lesson1.obstacle.Obstacle;
import com.batiaev.java2.lesson1.obstacle.Wall;
import com.batiaev.java2.lesson1.obstacle.Water;

public class Main {
    public static void main(String[] args) {
        Animal[] an = new Animal[5];
        an[0] = new Cat("Barsik");
        an[1] = new Dog("Bobik");
        an[2] = new Duck("Donald");
        an[3] = new Horse("Spirit");
        an[4] = new Human("Bob");

        Obstacle[] ob = new Obstacle[4];
        ob[0] = new Cross(200);
        ob[1] = new Wall(0.8f);
        ob[2] = new Water(2000);
        ob[3] = new Cross(800);

        for (int i = 0; i < an.length; i++) {
            for (int j = 0; j < ob.length; j++) {
                ob[j].doIt(an[i]);
                if (!an[i].isOnDistance()) break;
            }
        }

        for (int i = 0; i < an.length; i++) {
            if (an[i].isOnDistance())
                System.out.println(an[i].getName() + " WIN");
        }
    }
}
