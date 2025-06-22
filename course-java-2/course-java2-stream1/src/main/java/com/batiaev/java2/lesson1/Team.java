package com.batiaev.java2.lesson1;

import com.batiaev.java2.lesson1.animal.Animal;

/**
 * Team
 *
 * @author anton
 * @since 19/10/17
 */
public class Team {
    private String title;
    private Animal[] members;

    public Team(String title, Animal... members) {
        this.members = members;
        this.title = title;
    }

    public void printTeamInfo() {
        for (Animal a : members) {
            a.info();
        }
    }

    public void showResults() {
        System.out.println("Mates which passed the distance:");
        for (Animal a : members) {
            if (a.isOnDistance()) {
                a.info();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Animal[] getTeamMembers() {
        return members;
    }
}
