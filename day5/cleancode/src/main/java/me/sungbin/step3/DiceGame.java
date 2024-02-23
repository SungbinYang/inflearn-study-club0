package me.sungbin.step3;

/**
 * @author : rovert
 * @packageName : me.sungbin.step3
 * @fileName : DiceGame
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class DiceGame {
    private static final int SIDES_OF_DIE = 6;

    public static void main(String[] args) {
        int rolls = InputHandler.getNumberOfRolls();

        Dice dice = new Dice(SIDES_OF_DIE);
        DiceRollHandler roller = new DiceRollHandler(dice);

        roller.rollAll(rolls);

        OutputHandler.printResults(roller.getCounts());
    }
}
