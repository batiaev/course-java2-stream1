package com.batiaev.java3.lesson6;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class CustomRunner extends Runner {
    public CustomRunner(Class<?> clazz) {
        System.out.println("runner construct" + clazz.getCanonicalName());
    }
    @Override
    public Description getDescription() {
        return null;
    }

    @Override
    public void run(RunNotifier notifier) {
        System.out.println("hello from runner");
    }
}
