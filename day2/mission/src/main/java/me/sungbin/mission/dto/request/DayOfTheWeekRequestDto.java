package me.sungbin.mission.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DayOfTheWeekRequestDto {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public DayOfTheWeekRequestDto(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
