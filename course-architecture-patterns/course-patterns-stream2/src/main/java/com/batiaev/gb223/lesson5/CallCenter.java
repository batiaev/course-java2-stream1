package com.batiaev.gb223.lesson5;

import java.util.List;

/**
 * CallCenter
 *
 * @author anton
 * @since 30/07/19
 */
public class CallCenter implements Operator {
    private List<Operator> operators;
    @Override
    public void handle(String request) {
        for (Operator operator : operators) {
            operator.handle(request);
        }
    }
}
