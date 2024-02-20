package me.sungbin.mission.dto.response;

public record CalculateResponseRecordDto(int add, int minus, int multiply) {

    @Override
    public int add() {
        return add;
    }

    @Override
    public int minus() {
        return minus;
    }

    @Override
    public int multiply() {
        return multiply;
    }
}
