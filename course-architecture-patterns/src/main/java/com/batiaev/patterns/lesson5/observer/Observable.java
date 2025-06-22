package com.batiaev.patterns.lesson5.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void publishPost() {
        String message = createMessage();
        notifySubscribers(message);
    }

    private void notifySubscribers(String message) {
        observers.forEach(observer -> observer.process(message));
    }

    public String createMessage() {
        return UUID.randomUUID().toString();
    }
}
