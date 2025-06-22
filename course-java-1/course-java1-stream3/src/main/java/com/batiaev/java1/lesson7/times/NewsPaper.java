package com.batiaev.java1.lesson7.times;

/**
 * NewsPaper
 *
 * @author anton
 * @since 26/03/18
 */
public class NewsPaper {
    private Subscriber[] subscribers = new Subscriber[20];
    private int lastIndex = 0;

    public static void main(String[] args) {
        NewsPaper journal = new NewsPaper();
        Subscriber anton = new Subscriber();
        journal.subscribe(anton);
        journal.createNews();
    }
    public void subscribe(Subscriber subscriber) {
        subscribers[lastIndex] = subscriber;
        ++lastIndex;
    }

    public void createNews() {
        String article = "long article";
        for (int i = 0; i < lastIndex; i++) {
            Subscriber subscriber = subscribers[i];
            subscriber.notify(article);
        }
    }
}
