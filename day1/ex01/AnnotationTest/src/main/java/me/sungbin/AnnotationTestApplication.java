package me.sungbin;

import me.sungbin.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnotationTestApplication {

    int i;

    HelloController helloController;

    public static void main(String[] args) {
        SpringApplication.run(AnnotationTestApplication.class, args);
    }

}
