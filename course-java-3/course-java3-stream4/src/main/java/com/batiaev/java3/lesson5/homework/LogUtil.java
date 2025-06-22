package com.batiaev.java3.lesson5.homework;

import java.time.LocalTime;

class LogUtil {
    static void log(String msg) {
        System.out.format("[%s] %s%n", LocalTime.now(), msg);
    }
}
