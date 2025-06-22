package com.batiaev.patterns.lesson5.chain;

public abstract class AbstractHandler implements Handler {
    private AbstractHandler next;

    @Override
    public void handle() {
        if (next != null)
            next.handle();
    }

    public final AbstractHandler connect(AbstractHandler nextHander) {
        next = nextHander;
        return next;
    }
}
