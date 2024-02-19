package me.sungbin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final String hello = "/hello";

//    private String hello = "/hello";

    @GetMapping(hello)
    public String hello() {
        return "hello";
    }
}
