package me.sungbin.dto.fruit.response;

/**
 * @author : rovert
 * @packageName : me.sungbin.dto.fruit.response
 * @fileName : CountFruitNameResponseDto
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */
public class CountFruitNameResponseDto {

    private final long count;

    public CountFruitNameResponseDto(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
