package me.sungbin.mission.service;

import me.sungbin.mission.dto.request.CalculationRequestDto;
import me.sungbin.mission.dto.request.DayOfTheWeekRequestDto;
import me.sungbin.mission.dto.request.ListNumberDataRequestDto;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.Locale;

@Service
public class CalculationService {

    /**
     * 더하기 로직
     * @param requestDto
     * @return
     */
    public int add(CalculationRequestDto requestDto) {
        return requestDto.getNum1() + requestDto.getNum2();
    }

    /**
     * 빼기 로직
     * @param requestDto
     * @return
     */
    public int minus(CalculationRequestDto requestDto) {
        return requestDto.getNum1() - requestDto.getNum2();
    }

    /**
     * 곱하기 로직
     * @param requestDto
     * @return
     */
    public int multiply(CalculationRequestDto requestDto) {
        return requestDto.getNum1() * requestDto.getNum2();
    }

    /**
     * 요일 찾기 비즈니스 로직
     * @param requestDto
     * @return
     */
    public String findDayOfTheWeek(DayOfTheWeekRequestDto requestDto) {
        return requestDto.getDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }

    /**
     * 배열의 합 구하는 로직
     * @param requestDto
     * @return
     */
    public Integer sumOfNumbersInList(ListNumberDataRequestDto requestDto) {
        return requestDto.getNumbers().stream().mapToInt(Integer::intValue).sum();
    }
}
