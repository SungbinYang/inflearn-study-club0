package me.sungbin.blog;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : AnonymousClass
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class AnonymousClass {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스를 사용한 스레드 실행");
            }
        });

        myThread.start(); // Thread start
    }
}
