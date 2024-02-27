package me.sungbin.service;

import me.sungbin.dto.fruit.request.FruitRequestDto;
import me.sungbin.dto.fruit.request.SaveFruitInfoRequestDto;
import me.sungbin.dto.fruit.request.UpdateFruitRequestDto;
import me.sungbin.dto.fruit.response.CountFruitNameResponseDto;
import me.sungbin.dto.fruit.response.FruitResponseDto;
import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import me.sungbin.repository.FruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : rovert
 * @packageName : me.sungbin.service
 * @fileName : FruitService
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */

@Service
@Transactional(readOnly = true)
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    /**
     * 문제 1번 (과제6 문제 1)
     * @param requestDto
     */
    @Transactional
    public void saveFruitInfo(SaveFruitInfoRequestDto requestDto) {
        Fruit fruit = requestDto.toEntity();

        this.fruitRepository.save(fruit);
    }

    /**
     * 문제 1번 (과제 6 문제 2)
     * @param requestDto
     */
    @Transactional
    public void updateFruitInfo(UpdateFruitRequestDto requestDto) {
        Fruit fruit = this.fruitRepository.findById(requestDto.getId()).orElseThrow(IllegalArgumentException::new);
        fruit.updateSoldInfo(true);
    }

    /**
     * 문제 1번 (과제 6 문제 3)
     * @param name
     * @return
     */
    public GetFruitResponseDto getFruitInfo(String name) {
        GetFruitResponseDto fruitData = this.fruitRepository.getFruitSalesInfo(name);

        validateGetFruitAmount(fruitData.getSalesAmount(), fruitData.getNotSalesAmount());

        return fruitData;
    }

    /**
     * 문제 2번
     * @param name
     * @return
     */
    public CountFruitNameResponseDto countFruitName(String name) {
        long count = this.fruitRepository.countByNameAndIsSoldIsTrue(name);

        return new CountFruitNameResponseDto(count);
    }

    public List<FruitResponseDto> findSoldFruitListOfPrice(FruitRequestDto requestDto) {
        if (Objects.equals(requestDto.getOption(), "GTE")) {
            return this.fruitRepository.findAllByPriceGreaterThanEqualAndIsSoldIsFalse(requestDto.getPrice())
                    .stream().map(fruit -> new FruitResponseDto(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()))
                    .collect(Collectors.toList());
        } else if (Objects.equals(requestDto.getOption(), "LTE")) {
            return this.fruitRepository.findAllByPriceLessThanEqualAndIsSoldIsFalse(requestDto.getPrice())
                    .stream().map(fruit -> new FruitResponseDto(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()))
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("옵션은 GTE 혹은 LTE이여야 합니다.");
        }
    }

    private void validateGetFruitAmount(long salesAmount, long notSalesAmount) {
        if (salesAmount == 0L && notSalesAmount == 0L) {
            throw new IllegalArgumentException("존재하는 과일이 없습니다.");
        }
    }
}
