package me.sungbin;

import java.util.Scanner;

/**
 * @author : rovert
 * @packageName : me.sungbin
 * @fileName : ${NAME}
 * @date : 2/22/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/22/24       rovert         최초 생성
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0;

        for (int i = 0; i < a; i++) {
            double b = Math.random() * 6;

            if (b >= 0 && b < 1) {
                r1++;
            } else if (b >= 1 && b < 2) {
                r2++;
            } else if (b >= 2 && b < 3) {
                r3++;
            } else if (b >= 3 && b < 4) {
                r4++;
            } else if (b >= 4 && b < 5) {
                r5++;
            } else if (b >= 5 && b < 6) {
                r6++;
            }
        }

        System.out.printf("1은 %d번 나왔습니다.\n", r1);
        System.out.printf("2은 %d번 나왔습니다.\n", r2);
        System.out.printf("3은 %d번 나왔습니다.\n", r3);
        System.out.printf("4은 %d번 나왔습니다.\n", r4);
        System.out.printf("5은 %d번 나왔습니다.\n", r5);
        System.out.printf("6은 %d번 나왔습니다.\n", r6);
    }
}