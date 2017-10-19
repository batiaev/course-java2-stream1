package com.batiaev.java2.lesson1;

import com.batiaev.java2.lesson1.animal.Animal;
import com.batiaev.java2.lesson1.obstacle.Obstacle;

/**
 * Course
 *
 * @author anton
 * @since 19/10/17
 */
public class Course {
    private Obstacle[] obstacles = new Obstacle[3];

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Animal member : team.getTeamMembers()) {
            for (Obstacle obstacle : obstacles)
                obstacle.doIt(member);
        }
    }
}
