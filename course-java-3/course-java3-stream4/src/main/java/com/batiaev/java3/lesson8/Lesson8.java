package com.batiaev.java3.lesson8;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Lesson8
 *
 * @author anton
 * @since 12/09/19
 */
public class Lesson8 {
    public static void main(String[] args) throws NoSuchMethodException {

        Method method = Lesson8.class
                .getMethod("getStringList", null);

        Type returnType = method.getGenericReturnType();

        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }
    protected List<String> stringList = new ArrayList<>();

    public List<String> getStringList(){
        return this.stringList;
    }
}
