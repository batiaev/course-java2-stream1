package com.batiaev.java1.lesson7.times;

/**
 * Subscriber
 *
 * @author anton
 * @since 26/03/18
 */
public class Subscriber {
    private CreditCard creditCard = new CreditCard();

    public void notify(String news) {
        creditCard.charge(-15);
        System.out.println(news);
    }
}
