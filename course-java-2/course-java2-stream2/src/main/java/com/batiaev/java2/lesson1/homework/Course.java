package com.batiaev.java2.lesson1.homework;

import com.batiaev.java2.lesson1.Cat;
import com.batiaev.java2.lesson1.Dog;

public class Course {
    private Barrier[] barriers;

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    public static void main(String[] args) {
        Barrier[] barriers = new Barrier[5];
        barriers[0] = new Barrier();
        barriers[1] = new Wall(3);
        //add more...
        Course c = new Course(barriers); // Создаем полосу препятствий

        Team team = new Team("teamName", new Cat(), new Dog()); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }

    private void doIt(Team team) {
//        Member[] members = team.getMembers();
//        for (int i = 0; i < members.length; i++) {
//            Member member = members[i];
//
//        }


        for (Member member : team.getMembers()) {
            boolean result = true;
            for (Barrier barrier : barriers) {
                result &= barrier.doIt(member);
            }
            member.setResult(result);
        }
    }
}
