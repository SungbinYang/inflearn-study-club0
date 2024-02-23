package me.sungbin.step4;

/**
 * @author : rovert
 * @packageName : me.sungbin.step4
 * @fileName : DiceGame
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class DiceGame {
    private static final int SIDES_OF_DIE = 6; // 기본값, 필요에 따라 변경 가능

    public static void main(String[] args) {
        int rolls = InputHandler.getNumberOfRolls();
        DiceRollStrategy strategy = new StandardDiceRollStrategy(SIDES_OF_DIE); // 전략 선택
        Dice dice = new Dice(strategy);
        DiceRollHandler roller = new DiceRollHandler(dice);
        roller.rollAll(rolls);
        OutputHandler.printResults(roller.getCounts());
    }
}
