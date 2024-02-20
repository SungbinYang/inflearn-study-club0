package me.sungbin.mission.controller;

import jakarta.validation.Valid;
import me.sungbin.mission.dto.request.CalculationRequestDto;
import me.sungbin.mission.dto.request.DayOfTheWeekRequestDto;
import me.sungbin.mission.dto.request.ListNumberDataRequestDto;
import me.sungbin.mission.dto.response.CalculationResponseDto;
import me.sungbin.mission.dto.response.DayOfTheWeekResponseDto;
import me.sungbin.mission.service.CalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MissionController {

    private final CalculationService calculationService;

    public MissionController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/calc") // GET /api/v1/calc
    public CalculationResponseDto calculate(CalculationRequestDto requestDto) {
        return new CalculationResponseDto(this.calculationService.add(requestDto), calculationService.minus(requestDto), calculationService.multiply(requestDto));
    }

    @GetMapping("/day-of-the-week") // GET /api/v1/day-of-the-week
    public DayOfTheWeekResponseDto findDayOfTheWeek(DayOfTheWeekRequestDto requestDto) {
        return new DayOfTheWeekResponseDto(this.calculationService.findDayOfTheWeek(requestDto));
    }

    @PostMapping("/sum-of-numbers-in-list")
    public Integer sumOfNumbersInList(@RequestBody @Valid ListNumberDataRequestDto requestDto) {
        return this.calculationService.sumOfNumbersInList(requestDto);
    }
}
