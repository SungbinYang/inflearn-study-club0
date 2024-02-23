package me.sungbin.step3;

/**
 * @author : rovert
 * @packageName : me.sungbin.step3
 * @fileName : OutputHandler
 * @date : 2/23/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/23/24       rovert         최초 생성
 */
public class OutputHandler {
    public static void printResults(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%d은 %d번 나왔습니다.\n", i + 1, counts[i]);
        }
    }
}
