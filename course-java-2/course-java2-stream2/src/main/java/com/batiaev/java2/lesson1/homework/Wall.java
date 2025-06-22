package com.batiaev.java2.lesson1.homework;

public class Wall extends Barrier {
    private long size;

    public Wall(long size) {
        this.size = size;
    }

    @Override
    public boolean doIt(Member member) {
        return member.getAbility() > size;
    }
}
