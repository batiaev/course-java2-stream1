package com.batiaev.java1.lesson6;

/**
 * ConsoleLogger
 *
 * @author anton
 * @since 08/02/18
 */
public class ConsoleLogger extends AbstractListener
        implements Subscriber, Listener {
    @Override
    public void callBack() {
        int timeout = Subscriber.TIMEOUT;
        int timeout2 = Listener.TIMEOUT;
        System.out.println("Callback");
    }

    @Override
    public void longCallBack() {
        callBack();
        System.out.println("long callback");
    }

    @Override
    public void doWork() {
        //FIXME
    }
}
