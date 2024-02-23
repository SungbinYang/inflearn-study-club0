package me.sungbin.step4;

import java.util.Scanner;

/**
 * @author : rovert
 * @packageName : me.sungbin.step3
 * @fileName : InputHandler
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class InputHandler {
    public static int getNumberOfRolls() {
        System.out.print("숫자를 입력하세요 : ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }
}
