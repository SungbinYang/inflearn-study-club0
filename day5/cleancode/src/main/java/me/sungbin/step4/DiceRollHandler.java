package me.sungbin.step4;

/**
 * @author : rovert
 * @packageName : me.sungbin.step4
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
        this.counts = new int[dice.getSides()]; // 주사위 면 수에 맞는 크기로 배열 초기화
    }

    public void rollAll(int numberOfRolls) {
        for (int i = 0; i < numberOfRolls; i++) {
            int result = dice.roll() - 1; // 0부터 시작하는 배열 인덱스에 맞추기 위해 1을 뺌
            counts[result]++;
        }
    }

    public int[] getCounts() {
        return counts;
    }
}
