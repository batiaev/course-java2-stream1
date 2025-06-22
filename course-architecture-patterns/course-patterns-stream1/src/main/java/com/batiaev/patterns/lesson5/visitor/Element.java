package com.batiaev.patterns.lesson5.visitor;

public interface Element {
    default void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
