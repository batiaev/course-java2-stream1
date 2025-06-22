package com.batiaev.patterns.lesson6;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Registry<T extends Serializable> {

    private Map<Class<T>, T> services = new HashMap<>();

    public T getService(Class<T> tClass) {
        return services.get(tClass);
    }
}
