package me.sungbin.controller.fruit;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.sungbin.dto.fruit.request.SaveFruitInfoRequestDto;
import me.sungbin.dto.fruit.request.UpdateFruitRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : rovert
 * @packageName : me.sungbin.controller.fruit
 * @fileName : FruitControllerTest
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class FruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("문제 1번 통합 테스트 - 실패 (가격이 음수거나 과일 이름이 공란)")
    void question1_test_fail_caused_by_price_is_minus_or_fruit_name_is_empty() throws Exception {
        SaveFruitInfoRequestDto requestDto = new SaveFruitInfoRequestDto("", LocalDate.of(2024, 1, 1), -1000);

        this.mockMvc.perform(post("/api/v1/fruit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("문제 1번 통합 테스트 - 성공")
    void question1_test_success() throws Exception {
        SaveFruitInfoRequestDto requestDto = new SaveFruitInfoRequestDto("파인애플", LocalDate.of(2024, 2, 2), 20000);

        this.mockMvc.perform(post("/api/v1/fruit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("문제 2번 통합 테스트 - 성공")
    void question2_test_success() throws Exception {
        UpdateFruitRequestDto requestDto = new UpdateFruitRequestDto(1);

        this.mockMvc.perform(put("/api/v1/fruit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("문제 3번 통합 테스트 - 성공")
    void question3_test_success() throws Exception {
        this.mockMvc.perform(get("/api/v1/fruit/stat")
                        .param("name", "사과"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("과제 7번 문제 2번 통합 테스트 - 실패 (파라미터 존재 X)")
    void lesson7_question2_fail_test_caused_by_not_exists_request_parameter() throws Exception {
        this.mockMvc.perform(get("/api/v1/fruit/count"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("과제 7번 문제 2번 통합 테스트 - 성공")
    void lesson7_question2_test_success() throws Exception {
        this.mockMvc.perform(get("/api/v1/fruit/count")
                        .param("name", "사과"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("과제 7번 문제 2번 통합 테스트 - 실패 (파라미터 존재 X)")
    void lesson7_question3_fail_test_caused_by_not_exists_request_parameter() throws Exception {
        this.mockMvc.perform(get("/api/v1/fruit/list"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("과제 7번 문제 3번 통합 테스트 - 성공")
    void lesson7_question3_test_success() throws Exception {
        this.mockMvc.perform(get("/api/v1/fruit/list")
                        .param("option", "GTE")
                        .param("price", "3000"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}