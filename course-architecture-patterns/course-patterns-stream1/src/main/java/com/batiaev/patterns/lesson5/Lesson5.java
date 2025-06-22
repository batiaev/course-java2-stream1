package com.batiaev.patterns.lesson5;

import com.batiaev.patterns.lesson5.chain.AbstractHandler;
import com.batiaev.patterns.lesson5.chain.ConsoleExecutor;
import com.batiaev.patterns.lesson5.chain.PrintCommand;
import com.batiaev.patterns.lesson5.chain.RequestHandler;
import com.batiaev.patterns.lesson5.command.Command;
import com.batiaev.patterns.lesson5.command.Executor;
import com.batiaev.patterns.lesson5.interpreter.Intrerpreter;
import com.batiaev.patterns.lesson5.interpreter.StringContext;
import com.batiaev.patterns.lesson5.memento.Memento;
import com.batiaev.patterns.lesson5.observer.ConsoleObserver;
import com.batiaev.patterns.lesson5.observer.Observable;
import com.batiaev.patterns.lesson5.observer.Observer;
import com.batiaev.patterns.lesson5.strategy.Calculator;
import com.batiaev.patterns.lesson5.templateMethod.Processor;
import com.batiaev.patterns.lesson5.visitor.ComplexElement;
import com.batiaev.patterns.lesson5.visitor.Element;
import com.batiaev.patterns.lesson5.visitor.SmartVisitor;
import com.batiaev.patterns.lesson5.visitor.Visitor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * iterator()
 * interpreter()
 * memento()
 * state()
 * strategy()
 * templateMethod()
 * visitor()
 */
public class Lesson5 {
    public static void main(String[] args) {
//        chainOfResponsibility();
//        command();
//        mediator();
//        observer();
//        visitor();
//        iterator();
//        interpreter();
//        memento();
//        state();
//        strategy();
        templateMethod();
    }

    private static void templateMethod() {
        Processor processor = new Processor() {
            private String state = "Anton";

            @Override
            public void calculate() {
                System.out.println(state.length());
            }

            @Override
            public String loadParams() {
                return state;
            }
        };
        processor.process();
    }

    private static void strategy() {
        Calculator calculator = new Calculator();
        int sum = Stream.of(1, 3, 5, 8).mapToInt(v -> v).sum();
//        calculator.calculate((a,b) -> sum(a,b));
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static void state() {
        //quotation
    }

    private static void memento() {
        String name = "Anton";
        Memento memento = new Memento();
        memento.setState(name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String state = memento.getState();
        System.out.println(state);
    }

    private static void interpreter() {
        Intrerpreter intrerpreter = new Intrerpreter();
        intrerpreter.interpretate(new StringContext());
    }

    private static void iterator() {
        List<String> names = Arrays.asList("Anton", "Ivan");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    private static void visitor() {
        Visitor visitor = new SmartVisitor();
        Element element = new ComplexElement();
        element.accept(visitor);

    }

    private static void observer() {
        Observer observer1 = new ConsoleObserver("First");
        Observer observer2 = new ConsoleObserver("Second");
        Observable observable = new Observable();
        observable.subscribe(observer1);
        observable.subscribe(observer2);
        observable.publishPost();
    }

    private static void mediator() {
        ServiceDiscovery serviceDiscovery = new ServiceDiscovery();
//        CommissionService commissionService = new CommissionService();
        TransactionService transactionService = new TransactionService(serviceDiscovery);
    }

    private static void command() {
        Command task = new PrintCommand("Anton");
        Executor executor = new ConsoleExecutor();
        executor.exec(task);
    }

    private static void chainOfResponsibility() {
        AbstractHandler handler = new RequestHandler("AbstractHandler 1");
        handler.connect(new RequestHandler("AbstractHandler 2"))
                .connect(new RequestHandler("AbstractHandler 3"))
                .connect(handler);

        for (int i = 0; i < 10; i++) {
            handler.handle();
        }
    }
}
