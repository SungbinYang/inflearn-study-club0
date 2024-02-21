package me.sungbin.blog;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : Eating
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class Eating {

    private String food;

    public Eating() {
    }

    public Eating(String food) {
        this.food = food;
    }

    public String eat(String food) {
        return "eating " + food;
    }

    public static String keepEat(String food) {
        return "keep eating " + food;
    }
}
