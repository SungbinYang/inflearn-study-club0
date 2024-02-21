package me.sungbin.blog;

import java.util.Arrays;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : LambdaBlogEx1
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class LambdaBlogEx1 {
    public static void main(String[] args) {
        int[] arr = new int[5];

        Arrays.setAll(arr, (i) -> (int)(Math.random() * 5) + 1);
    }
}
