package me.sungbin.blog;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : FCOnlineExample
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class FCOnlineExample {
    public static void main(String[] args) {
        FCOnline fcOnline1 = new FCOnline();
        fcOnline1.playing(new Ready() {
            @Override
            public void setup() {
                System.out.println("is Ready?");
            }
        });

        FCOnline fcOnline2 = new FCOnline();

        fcOnline2.playing(() -> System.out.println("is Ready!"));
    }
}
