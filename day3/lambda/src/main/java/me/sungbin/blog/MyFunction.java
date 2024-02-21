package me.sungbin.blog;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : MyFunction
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */

@FunctionalInterface
public interface MyFunction {
    void printAnyThing(String name);

    static void printNumber() {
        System.out.println(1);
    }

    default void printDefaultNumber() {
        System.out.println(0);
    }
}
