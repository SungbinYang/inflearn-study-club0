package me.sungbin.step4;

/**
 * @author : rovert
 * @packageName : me.sungbin.step4
 * @fileName : Dice
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class Dice {
    private final DiceRollStrategy strategy;

    public Dice(DiceRollStrategy strategy) {
        this.strategy = strategy;
    }

    public int roll() {
        return strategy.roll();
    }

    // 주사위의 면 수를 반환하는 메소드 추가
    public int getSides() {
        return this.strategy.getSides();
    }
}
