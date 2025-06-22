package com.batiaev.java3.lesson7;

import lombok.extern.slf4j.Slf4j;

import javax.jws.WebService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@FirstAnnotation(priority = 15)
@Slf4j
@SuppressWarnings("asd")
@WebService
public class Lesson7 {
    private String name = "Test";

    public static void main(String[] args) throws RuntimeException {

        Lesson7 lesson7 = new Lesson7();
        Class<? extends Lesson7> aClass = lesson7.getClass();
        Method[] methods = aClass.getMethods();
        Modifier.isStatic(methods[0].getModifiers());
        int anAbstract = Modifier.ABSTRACT;
//        log.info();
        System.out.println(
                aClass.isAnnotation() ? "@interface " : "class " + aClass.getSimpleName());

        System.out.println(aClass.getSimpleName());
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass.getSimpleName());
//        Class<?> superclass2 = superclass.getSuperclass();
//        System.out.println(superclass2.getSimpleName());

        aClass.getAnnotations();
        FirstAnnotation annotation = aClass.getAnnotation(FirstAnnotation.class);
        String value = annotation.value();
        System.out.println(value);

        process(lesson7);

        Field[] fields2 = aClass.getFields();
        Field[] fields = aClass.getDeclaredFields();
        System.out.println(fields);

        try {
            Lesson7 lesson71 = aClass.getConstructor().newInstance();
            lesson7.setName("example");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

//        log.info(aClass.getName());
//        log.info(aClass.getSimpleName());
//        log.info(aClass.getCanonicalName());
//        log.info(aClass.getTypeName());

//        ResultSet resultSet = null;
//        try {
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            metaData.getColumnCount();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private static void process(Lesson7 lesson7) {
        Class<? extends Lesson7> aClass = lesson7.getClass();
        FirstAnnotation annotation = aClass.getAnnotation(FirstAnnotation.class);
        if (Integer.valueOf(annotation.value()) > 10) {
            System.out.println("Too much");
        } else {
            System.out.println("2 low");
        }

    }

    private void setName(String example) {
        name = example;
    }
}
