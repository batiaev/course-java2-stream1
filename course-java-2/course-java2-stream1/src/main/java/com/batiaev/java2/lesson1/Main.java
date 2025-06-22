package com.batiaev.java2.lesson1;

import com.batiaev.java2.lesson1.animal.*;
import com.batiaev.java2.lesson1.obstacle.Cross;
import com.batiaev.java2.lesson1.obstacle.Obstacle;
import com.batiaev.java2.lesson1.obstacle.Wall;
import com.batiaev.java2.lesson1.obstacle.Water;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Barsik");
        Animal dog = new Dog("Bobik");
        Animal duck = new Duck("Donald");
        Animal horse = new Horse("Spirit");
        Animal human = new Human("Bob");

        Obstacle cross = new Cross(15);
        Obstacle wall = new Wall(0.8f);
        Obstacle water = new Water(200);

        // Создаем полосу препятствий
        Course c = new Course(wall, water, cross);
        // Создаем команду
        Team team = new Team("bestTeam", human, horse, cat, dog, duck);
        System.out.println("Team info:");
        team.printTeamInfo();
        System.out.println("---");
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
