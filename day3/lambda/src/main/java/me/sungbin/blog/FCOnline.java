package me.sungbin.blog;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : FCOnline
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */

@FunctionalInterface
interface Ready {
    void setup();
}

public class FCOnline {
    public void playing(Ready ready) {
        ready.setup();

        System.out.println("FC Online is playing");
    }
}
