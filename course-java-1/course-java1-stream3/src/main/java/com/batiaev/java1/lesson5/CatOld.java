package com.batiaev.java1.lesson5;

/**
 * CatOld
 *
 * @author anton
 * @since 19/03/18
 */
public class CatOld {
    private final String name;
    String color;
    public int age;

    public CatOld(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    private CatOld(String name) {
        this(name, "white", 0);
    }

    public static int count = 0;

    public static CatOld create(String name) {
        if (count < 5)
            return new CatOld(name);
        else {
            System.out.println("limit of cats is " + count);
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) return true;
//        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatOld cat = (CatOld) o;

        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
