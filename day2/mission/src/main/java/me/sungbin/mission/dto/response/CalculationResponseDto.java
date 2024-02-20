package me.sungbin.mission.dto.response;

public class CalculationResponseDto {

    private final int add;

    private final int minus;

    private final int multiply;

    public CalculationResponseDto(int add, int minus, int multiply) {
        this.add = add;
        this.minus = minus;
        this.multiply = multiply;
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}
