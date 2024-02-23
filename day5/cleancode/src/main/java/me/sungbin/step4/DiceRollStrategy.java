package me.sungbin.step4;

/**
 * @author : rovert
 * @packageName : me.sungbin.step4
 * @fileName : DiceRollStrategy
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public interface DiceRollStrategy {
    int roll();
    int getSides(); // 면 수를 반환하는 메소드 추가
}
