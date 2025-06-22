package com.batiaev.java3.lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.Function;

/**
 * Lesson7
 *
 * @author anton
 * @since 09/09/19
 */
public class Lesson7 {
    public static void main(String[] args) {
        String id = "my bank";
        Account account = new BankAccount(id);
        ((BankAccount) account).setCardId(UUID.randomUUID().toString());

//        lookDeeper(account);
        save(account);
        lambdas();
    }

    private static void lambdas() {
        Thread thread = new Thread();
        thread = new Thread();
        Function<String, Double> stringDoubleFunction =
                Double::parseDouble;
        double apply = stringDoubleFunction.apply("3.14");
        apply = 4;
        Thread finalThread = thread;
        final double[] finalApply = {apply};
        Runnable runnable = () -> {
            finalThread.start();
            finalApply[0] = 5;
            print();
        };

        print();
    }

    private static void print() {
        System.out.println("hello");
    }

    private static void save(Account account) {
        final Table annotation = account.getClass().getAnnotation(Table.class);
        String tableName;
        tableName = annotation != null
                ? annotation.name()
                : account.getClass().getSimpleName().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM " + tableName + " WHERE ");
        for (Field field : account.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                stringBuilder.append(field.getName())
                        .append(" = ")
                        .append(field.get(account));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println(stringBuilder.append(";").toString());

    }

    private static void lookDeeper(Account account) {
        final Class<? extends Account> clazz = account.getClass();
        final int modifiers = clazz.getModifiers();
        System.out.println(Modifier.toString(modifiers));
        System.out.println(Modifier.toString(BankAccount.class.getModifiers()));
        System.out.println(Modifier.toString(Account.class.getModifiers()));

        final Method[] methods = clazz.getDeclaredMethods();
        try {
            final Object invoke = methods[0].invoke(account);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        final int methodModifiers = methods[0].getModifiers();
        System.out.println(Arrays.toString(methods));

        final Field[] declaredFields = clazz.getDeclaredFields();
        final String name = declaredFields[0].getName();
        final Class<?> type = declaredFields[0].getType();
//        final String name = declaredFields[0].getAnnotation();
        final int modifiers1 = declaredFields[0].getModifiers();

        System.out.println("#### Constructors");
        final Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        try {
            final Constructor<? extends Account> constructor = clazz.getConstructor();
            final Account newInstance = constructor.newInstance();
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(declaredConstructors));
        final Annotation[] declaredAnnotations = declaredConstructors[0]
                .getDeclaredAnnotations();

    }
}
