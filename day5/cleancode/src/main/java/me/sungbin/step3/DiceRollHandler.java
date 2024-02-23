package me.sungbin.step3;

/**
 * @author : rovert
 * @packageName : me.sungbin.step3
 * @fileName : DiceRollHandler
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class DiceRollHandler {
    private final Dice dice;
    private final int[] counts;

    public DiceRollHandler(Dice dice) {
        this.dice = dice;
        this.counts = new int[dice.getSides()];
    }

    public void rollAll(int numberOfRolls) {
        for (int i = 0; i < numberOfRolls; i++) {
            counts[dice.roll()]++;
        }
    }

    public int[] getCounts() {
        return counts;
    }
}
