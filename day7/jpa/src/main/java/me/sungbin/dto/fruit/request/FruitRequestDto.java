package me.sungbin.dto.fruit.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author : rovert
 * @packageName : me.sungbin.dto.fruit.request
 * @fileName : FruitRequestDto
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */
public class FruitRequestDto {

    @NotBlank(message = "option은 공란일 수 없습니다.")
    @NotNull(message = "option은 반드시 있어야 합니다.")
    private final String option;

    private final long price;

    public FruitRequestDto(String option, long price) {
        this.option = option;
        this.price = price;
    }

    public String getOption() {
        return option;
    }

    public long getPrice() {
        return price;
    }
}
