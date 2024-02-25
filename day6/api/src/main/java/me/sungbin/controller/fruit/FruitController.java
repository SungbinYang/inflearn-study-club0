package me.sungbin.controller.fruit;

import jakarta.validation.Valid;
import me.sungbin.dto.fruit.request.SaveFruitInfoRequestDto;
import me.sungbin.dto.fruit.request.UpdateFruitRequestDto;
import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import me.sungbin.service.fruit.FruitService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author : rovert
 * @packageName : me.sungbin.controller.fruit
 * @fileName : FruitController
 * @date : 2/25/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/25/24       rovert         최초 생성
 */

@RestController
@RequestMapping("/api/v1/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    public void saveFruitInfo(@RequestBody @Valid SaveFruitInfoRequestDto requestDto) {
        this.fruitService.saveFruitInfo(requestDto);
    }

    @PutMapping
    public void updateFruitInfo(@RequestBody UpdateFruitRequestDto requestDto) {
        this.fruitService.updateFruitInfo(requestDto);
    }

    @GetMapping("/stat")
    public GetFruitResponseDto getFruitInfo(@RequestParam String name) {
        return this.fruitService.getFruitInfo(name);
    }

}
