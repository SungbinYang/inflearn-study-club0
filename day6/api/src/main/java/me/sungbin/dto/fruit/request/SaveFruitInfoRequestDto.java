package me.sungbin.dto.fruit.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.sungbin.entity.fruit.Fruit;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author : rovert
 * @packageName : me.sungbin.dto.fruit.request
 * @fileName : SaveFruitInfoRequestDto
 * @date : 2/25/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/25/24       rovert         최초 생성
 */
public class SaveFruitInfoRequestDto {

    @NotBlank(message = "과일 이름이 공란일 수 없습니다.")
    @NotNull(message = "과일 이름이 null일 수는 없습니다.")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate warehousingDate;


    @Min(value = 0, message = "가격이 음수가 될 수는 없습니다.")
    private long price;

    public SaveFruitInfoRequestDto(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public Fruit toEntity() {
        return new Fruit(name, warehousingDate, price);
    }
}
