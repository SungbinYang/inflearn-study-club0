package me.sungbin.mission.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ListNumberDataRequestDto {

    @NotEmpty(message = "리스트의 적어도 하나의 원소가 존재해야 합니다.`")
    @NotNull(message = "리스트는 null일 수 없습니다.")
    private final List<Integer> numbers;

    public ListNumberDataRequestDto(@JsonProperty("numbers") List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
