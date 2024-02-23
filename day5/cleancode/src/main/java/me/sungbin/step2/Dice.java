package me.sungbin.step2;

/**
 * @author : rovert
 * @packageName : me.sungbin.step2
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

    /**
     * 주사위 면의 숫자 구하기
     * @return
     */
    public int roll() {
        return (int) (Math.random() * sides);
    }

    public int getSides() {
        return sides;
    }
}
