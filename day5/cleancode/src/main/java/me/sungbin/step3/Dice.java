package me.sungbin.step3;

/**
 * @author : rovert
 * @packageName : me.sungbin.step3
 * @fileName : Dice
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class Dice {
    private final int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return (int) (Math.random() * sides);
    }

    public int getSides() {
        return sides;
    }
}
