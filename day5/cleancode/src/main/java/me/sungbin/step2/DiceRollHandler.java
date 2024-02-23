package me.sungbin.step2;

/**
 * @author : rovert
 * @packageName : me.sungbin.step2
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

    public DiceRollHandler(Dice dice, int numberOfRolls) {
        this.dice = dice;
        this.counts = new int[dice.getSides()];
        for (int i = 0; i < numberOfRolls; i++) {
            this.counts[dice.roll()]++;
        }
    }

    public void rollAll() {
        for (int i = 0; i < counts.length; i++) {
            counts[dice.roll()]++;
        }
    }

    public void printResults() {
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%d은 %d번 나왔습니다.\n", i + 1, counts[i]);
        }
    }
}
