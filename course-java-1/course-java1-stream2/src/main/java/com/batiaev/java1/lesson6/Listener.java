package com.batiaev.java1.lesson6;

/**
 * Listener
 *
 * @author anton
 * @since 08/02/18
 */
public interface Listener {

    int TIMEOUT = 10;

    void callBack();

    default void longCallBack() {
        callBack();
    }
}
