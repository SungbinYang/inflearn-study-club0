package me.sungbin.dto.fruit.response;

import java.time.LocalDate;

/**
 * @author : rovert
 * @packageName : me.sungbin.dto.fruit.response
 * @fileName : FruitResponseDto
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */
public class FruitResponseDto {

    private final String name;

    private final long price;

    private final LocalDate warehousingDate;

    public FruitResponseDto(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }
}
