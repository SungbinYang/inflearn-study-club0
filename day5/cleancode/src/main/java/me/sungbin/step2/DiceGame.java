package me.sungbin.step2;

import java.util.Scanner;

/**
 * @author : rovert
 * @packageName : me.sungbin.step2
 * @fileName : Main
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class DiceGame {

    private static final int SIDES_OF_DICE = 6;
    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int rolls = scanner.nextInt();
        scanner.close();

        Dice dice = new Dice(SIDES_OF_DICE); // 정해진 면의 수를 가진 주사위 객체 생성
        DiceRollHandler handler = new DiceRollHandler(dice, rolls); // 주사위를 던지는 이벤트에 대한 핸들러 객체 생성
        handler.rollAll(); // 주사위 던지기 이벤트 비즈니스 로직
        handler.printResults(); // 출력
    }
}
