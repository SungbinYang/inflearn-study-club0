package me.sungbin.repository.fruit;

import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;

/**
 * @author : rovert
 * @packageName : me.sungbin.repository.fruit
 * @fileName : FruitRepository
 * @date : 2/25/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/25/24       rovert         최초 생성
 */
public interface FruitRepository {

    void saveFruitInfo(Fruit fruit); // 과일 생성

    void updateFruitInfo(long id); // 과일 정보 업데이트

    GetFruitResponseDto getFruitInfo(String name); // 과일 조회

    boolean isNotExistsFruitInfo(long id);
}
