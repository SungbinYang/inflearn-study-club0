package me.sungbin.mission.dto.response;

public class DayOfTheWeekResponseDto {
    private final String dayOfTheWeek;

    public DayOfTheWeekResponseDto(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
