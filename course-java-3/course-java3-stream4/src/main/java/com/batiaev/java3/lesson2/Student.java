package com.batiaev.java3.lesson2;

/**
 * Student
 *
 * @author anton
 * @since 22/08/19
 */
public class Student {
    private final String name;
    private final String group;
    private final int score;

    public Student(String name, String group, int score) {
        this.name = name;
        this.group = group;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " from " + group + " with score " + score;
    }
}
