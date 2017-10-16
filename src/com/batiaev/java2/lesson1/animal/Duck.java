package com.batiaev.java2.lesson1.animal;

/**
 * Duck
 *
 * @author anton
 * @since 16/10/17
 */
public class Duck extends Animal implements Swimable {
    public Duck(String name) {
        this.name = name;
        animType = "Duck";
        onDistance = true;
        maxRunDistance = 50;
    }

    public void swim(float dist) {
        if(dist < 15000) {
            System.out.println(animType + " water ok");
        } else {
            getOutFromDistance("swim");
        }
    }
}
