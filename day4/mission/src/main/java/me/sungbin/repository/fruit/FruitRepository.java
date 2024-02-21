package me.sungbin.repository.fruit;

import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;

/**
 * @author : rovert
 * @packageName : me.sungbin.repository.fruit
 * @fileName : FruitRepository
 * @date : 2/22/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/22/24       rovert         최초 생성
 */
public interface FruitRepository {
    void saveFruitInfo(Fruit fruit);

    void updateFruitInfo(long id);

    GetFruitResponseDto getFruitInfo(String name);
}
