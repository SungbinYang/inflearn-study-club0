package me.sungbin;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Arrays.stream(Child.class.getAnnotations()).forEach(System.out::println);

        Annotation[] annotations = Sungbin.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("toString : " + annotation.toString());
            System.out.println("equals : " + annotation.equals(annotation));
            System.out.println("hashCode : " + annotation.hashCode());
            System.out.println("annotationType : " + annotation.annotationType());
        }

    }
}
