package me.sungbin.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : rovert
 * @packageName : me.sungbin.step4
 * @fileName : DiceRollHandlerTest
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
class DiceRollHandlerTest {

    @Test
    @DisplayName("Dice 클래스의 주사위 롤링 기능이 1부터 6 사이의 값을 정확히 생성하는지 검증")
    public void testDiceRoll() {
        DiceRollStrategy strategy = new StandardDiceRollStrategy(6);
        Dice dice = new Dice(strategy);
        int result = dice.roll();

        assertTrue(result >= 1 && result <= 6);
    }

    @Test
    @DisplayName("StandardDiceRollStrategy 클래스를 통해 생성된 주사위 값이 1부터 6 사이인지 확인")
    public void testStandardDiceRollStrategy() {
        StandardDiceRollStrategy strategy = new StandardDiceRollStrategy(6);
        int result = strategy.roll();
        assertTrue(result >= 1 && result <= 6);
    }
}