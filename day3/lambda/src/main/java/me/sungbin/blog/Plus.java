package me.sungbin.blog;

import java.util.function.Function;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : Plus
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class Plus implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 100;
    }
}
