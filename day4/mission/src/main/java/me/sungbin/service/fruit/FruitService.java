package me.sungbin.service.fruit;

import me.sungbin.dto.fruit.request.SaveFruitInfoRequestDto;
import me.sungbin.dto.fruit.request.UpdateFruitRequestDto;
import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import me.sungbin.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

/**
 * @author : rovert
 * @packageName : me.sungbin.service.fruit
 * @fileName : FruitService
 * @date : 2/22/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/22/24       rovert         최초 생성
 */
@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruitInfo(SaveFruitInfoRequestDto requestDto) {
        Fruit fruit = requestDto.toEntity();

        this.fruitRepository.saveFruitInfo(fruit);
    }

    public void updateFruitInfo(UpdateFruitRequestDto requestDto) {
        this.fruitRepository.updateFruitInfo(requestDto.getId());
    }

    public GetFruitResponseDto calculateSalesAmountAndNotSalesAmount(String name) {
        return this.fruitRepository.getFruitInfo(name);
    }
}
