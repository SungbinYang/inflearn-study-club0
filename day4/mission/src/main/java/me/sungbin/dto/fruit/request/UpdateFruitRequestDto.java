package me.sungbin.dto.fruit.request;

/**
 * @author : rovert
 * @packageName : me.sungbin.dto.fruit.request
 * @fileName : UpdateFruitRequestDto
 * @date : 2/22/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/22/24       rovert         최초 생성
 */
public class UpdateFruitRequestDto {
    private long id;

    public UpdateFruitRequestDto() {
    }

    public UpdateFruitRequestDto(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
