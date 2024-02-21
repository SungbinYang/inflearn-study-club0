package me.sungbin;

import me.sungbin.lecture.Fruit;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author : rovert
 * @packageName : org.example
 * @fileName : ${NAME}
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1_000),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_500),
                new Fruit("바나나", 3_000),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 2_500),
                new Fruit("수박", 10_000)
        );

        filterFruits(fruits, Fruit::isApple);
    }

    private static List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        return fruits.stream().filter(fruitFilter).collect(Collectors.toList());
    }
}