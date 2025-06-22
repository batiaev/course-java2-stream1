package com.batiaev.java3.lesson7;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Lesson7 {
    public static void main(String[] args) {
        //FIXME

        Map<String, Object> record = new HashMap<>();
        record.put("name", "apple");
        record.put("id", "123/13");
        record.put("price", 3.1415);

        Good good = process(record);

        recreateClass(Good.class);
        processConstructors(Good.class);
    }

    @LogParams
    private static void processConstructors(Class<Good> goodClass) {
        Constructor<Good>[] constructors = (Constructor<Good>[]) goodClass.getConstructors();
        for (Constructor<Good> constructor : constructors) {
            if (constructor.getParameterCount() == 0) {
                try {
                    Good newInstance = constructor.newInstance();
                    System.out.println("Price = " + newInstance.getPrice());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Arrays.toString(constructor.getParameterTypes()));
            }
        }

        try {
            Good good1 = goodClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void recreateClass(Class<Good> goodClass) {
        int modifiers = goodClass.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);

        System.out.println(goodClass.getPackage() + ";");
        System.out.println((isPublic ? "public" : "") + " "
                + (isFinal ? " final class " : " class ")
                + goodClass.getSimpleName());
    }

    public static Good process(Map<String, Object> record) {
        Class<? extends Good> goodClass = Good.class;

        double price = 0.0;
        String goodName = "";
        String barcode = null;
        for (Field field : goodClass.getDeclaredFields()) {
            String name = field.getName();
            Object value = record.get(name);
            if ("name".equals(name)) {
                goodName = (String) value;
            } else if ("price".equals(name)) {
                price = (double) value;
            } else {
                Column annotation = field.getAnnotation(Column.class);
                if (annotation != null) {
                    String field1 = annotation.field();
                    barcode = (String) record.get(field1);
                }
            }
            System.out.println("Process " + name + " field");
        }

        Good good = new Good(goodName, price);
        good.setBarcode(barcode);
        return good;
    }
}
