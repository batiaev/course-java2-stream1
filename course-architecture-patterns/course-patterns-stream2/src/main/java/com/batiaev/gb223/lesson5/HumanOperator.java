package com.batiaev.gb223.lesson5;

/**
 * HumanOperator
 *
 * @author anton
 * @since 30/07/19
 */
public class HumanOperator implements Operator {
    private boolean busy;
    private Operator nextOperator;

    @Override
    public void handle(String request) {
        if (busy)
            nextOperator.handle(request);
        else {
            busy = true;
            doHandle();
            busy = false;
        }
    }

    private void doHandle() {
        //FIXME
    }
}
