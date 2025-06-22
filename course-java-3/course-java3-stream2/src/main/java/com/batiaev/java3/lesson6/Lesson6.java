package com.batiaev.java3.lesson6;

import com.batiaev.java3.lesson4.Account;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lesson6 {
    public static void main(String[] args) {
        log.debug("App started");
        Account arg = new Account();
        arg.setId(123);
        if (log.isDebugEnabled()) log.info("{}", calclutatonResult());
        log.trace("Set account id = {}", arg.getId());
        log.info("My account = {}", arg);
        //FIXME
        log.debug("App finished");
    }

    private static String calclutatonResult() {
        for (int i = 0; i < 10000; i++) {
            //do something ...
        }
        return "result";
    }

    public long sum(long val1, long val2) {
        return val1 + val2;
    }

    public long sqrt(long val1) {
        return val1;
    }

    public long calculateValue(int i, int i1) {
        return i - i1;
    }
}
