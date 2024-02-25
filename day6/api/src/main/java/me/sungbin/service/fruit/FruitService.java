package me.sungbin.service.fruit;

import me.sungbin.dto.fruit.request.SaveFruitInfoRequestDto;
import me.sungbin.dto.fruit.request.UpdateFruitRequestDto;
import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import me.sungbin.repository.fruit.FruitMysqlRepository;
import me.sungbin.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

/**
 * @author : rovert
 * @packageName : me.sungbin.service.fruit
 * @fileName : FruitService
 * @date : 2/25/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/25/24       rovert         최초 생성
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
        validate(requestDto.getId());

        this.fruitRepository.updateFruitInfo(requestDto.getId());
    }

    public GetFruitResponseDto getFruitInfo(String name) {
        GetFruitResponseDto fruitData = this.fruitRepository.getFruitInfo(name);

        validateGetFruitAmount(fruitData.getSalesAmount(), fruitData.getNotSalesAmount());

        return fruitData;
    }

    private void validate(long id) {
        if (this.fruitRepository.isNotExistsFruitInfo(id)) {
            throw new IllegalArgumentException("존재하는 과일정보가 없습니다.");
        }
    }

    private void validateGetFruitAmount(long salesAmount, long notSalesAmount) {
        if (salesAmount == 0L && notSalesAmount == 0L) {
            throw new IllegalArgumentException("존재하는 과일이 없습니다.");
        }
    }
}
