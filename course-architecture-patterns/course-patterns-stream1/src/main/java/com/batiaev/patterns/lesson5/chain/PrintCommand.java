package com.batiaev.patterns.lesson5.chain;

import com.batiaev.patterns.lesson5.command.Command;

public class PrintCommand implements Command {
    private final String name;

    public PrintCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("My name is " + name);
    }
}
