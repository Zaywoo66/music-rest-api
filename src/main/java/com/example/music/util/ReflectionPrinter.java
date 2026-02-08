package com.example.music.util;

import java.lang.reflect.Field;

public class ReflectionPrinter {

    public static void printObjectFields(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("Reflection info about: " + clazz.getName());

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);
                System.out.println(field.getName() + " = " + value);
            } catch (IllegalAccessException e) {
                System.out.println(field.getName() + " = [ACCESS DENIED]");
            }
        }
    }
}
