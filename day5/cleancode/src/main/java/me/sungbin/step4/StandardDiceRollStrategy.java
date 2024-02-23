package me.sungbin.step4;

/**
 * @author : rovert
 * @packageName : me.sungbin.step4
 * @fileName : StandardDiceRollStrategy
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class StandardDiceRollStrategy implements DiceRollStrategy {

    private final int sides;

    public StandardDiceRollStrategy(int sides) {
        this.sides = sides;
    }

    @Override
    public int roll() {
        return (int) (Math.random() * sides) + 1;
    }

    @Override
    public int getSides() {
        return this.sides;
    }
}
