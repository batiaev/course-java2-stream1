package com.batiaev.patterns.lesson5.command;

public class Executor<T extends Command> {
    public void exec(T command) {
        command.execute();
    }
}
