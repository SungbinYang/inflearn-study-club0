package me.sungbin.step1;

import java.util.Scanner;

/**
 * @author : rovert
 * @packageName : me.sungbin.step1
 * @fileName : Main
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class Main {

    private static final int SIDES_OF_DICE = 6;

    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int rolls = scanner.nextInt();
        scanner.close();

        int[] counts = rollDice(rolls);
        printResults(counts);
    }

    /**
     * 주사위를 굴리는 로직이 들어가는 메서드
     * @param numberOfRolls
     * @return
     */
    private static int[] rollDice(int numberOfRolls) {
        int[] counts = new int[SIDES_OF_DICE];
        for (int i = 0; i < numberOfRolls; i++) {
            int result = (int) (Math.random() * SIDES_OF_DICE);
            counts[result]++;
        }
        return counts;
    }

    /**
     * 출력기능을 담당하는 메서드
     * @param counts
     */
    private static void printResults(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%d은 %d번 나왔습니다.\n", i + 1, counts[i]);
        }
    }
}
