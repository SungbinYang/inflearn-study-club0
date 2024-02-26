package me.sungbin.service;

import me.sungbin.dto.fruit.request.SaveFruitInfoRequestDto;
import me.sungbin.dto.fruit.request.UpdateFruitRequestDto;
import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import me.sungbin.repository.FruitJdbcRepository;
import org.springframework.stereotype.Service;

/**
 * @author : rovert
 * @packageName : me.sungbin.service
 * @fileName : FruitJdbcService
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */

@Service
public class FruitJdbcService {

    private final FruitJdbcRepository fruitRepository;

    public FruitJdbcService(FruitJdbcRepository fruitRepository) {
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
