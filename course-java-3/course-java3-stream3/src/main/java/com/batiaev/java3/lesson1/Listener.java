package com.batiaev.java3.lesson1;

import java.util.List;

public class Listener<T extends Event> {

    public void setIgnoredKeys(List<String> ignoredKeys) {
        this.ignoredKeys = ignoredKeys;
    }

    private List<String> ignoredKeys;

    void onEvent(T event) {
        if (ignoredKeys.contains(event.getKey())) return;

        double value = event.getData();
        String route = event.getClass().getSimpleName();
        System.out.println(route + " current value updated to " + value);
        //FIXME
    }
}
