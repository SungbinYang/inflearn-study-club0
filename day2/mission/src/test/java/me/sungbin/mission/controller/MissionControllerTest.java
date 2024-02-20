package me.sungbin.mission.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.sungbin.mission.dto.request.CalculationRequestDto;
import me.sungbin.mission.dto.request.DayOfTheWeekRequestDto;
import me.sungbin.mission.dto.request.ListNumberDataRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MissionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("문제 1번 통합 테스트 - 성공")
    void calculate_test_success() throws Exception {
        CalculationRequestDto calculationRequestDto = new CalculationRequestDto(10, 5);

        this.mockMvc.perform(get("/api/v1/calc")
                        .param("num1", String.valueOf(calculationRequestDto.getNum1()))
                        .param("num2", String.valueOf(calculationRequestDto.getNum2())))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("문제 2번 통합 테스트 - 성공")
    void find_day_of_the_week_test_success() throws Exception {
        DayOfTheWeekRequestDto requestDto = new DayOfTheWeekRequestDto(LocalDate.of(2023, 1, 1));

        this.mockMvc.perform(get("/api/v1/day-of-the-week")
                        .param("date", String.valueOf(requestDto.getDate())))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("문제 3번 통합 테스트 - 실패 (빈 List)")
    void sum_of_the_list_numbers_test_fail_caused_by_list_empty() throws Exception {
        List<Integer> list = new ArrayList<>();
        ListNumberDataRequestDto requestDto = new ListNumberDataRequestDto(list);

        this.mockMvc.perform(post("/api/v1/sum-of-numbers-in-list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("문제 3번 통합 테스트 - 실패 (null인 List)")
    void sum_of_the_list_numbers_test_fail_caused_by_list_null() throws Exception {
        List<Integer> list = null;
        ListNumberDataRequestDto requestDto = new ListNumberDataRequestDto(list);

        this.mockMvc.perform(post("/api/v1/sum-of-numbers-in-list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("문제 3번 통합 테스트 - 성공")
    void sum_of_the_list_numbers_test_success() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNumberDataRequestDto requestDto = new ListNumberDataRequestDto(list);

        this.mockMvc.perform(post("/api/v1/sum-of-numbers-in-list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}