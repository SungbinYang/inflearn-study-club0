package me.sungbin.repository;

import me.sungbin.dto.fruit.response.FruitResponseDto;
import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : rovert
 * @packageName : me.sungbin.repository
 * @fileName : FruitRepository
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */

@Transactional(readOnly = true)
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query("SELECT new me.sungbin.dto.fruit.response.GetFruitResponseDto(SUM(case when f.isSold = true then f.price else 0 end), SUM(case when f.isSold = false then f.price else 0 end)) FROM Fruit f WHERE f.name = :name")
    GetFruitResponseDto getFruitSalesInfo(@Param("name") String name); // 과제 6 문제 3번

    long countByNameAndIsSoldIsTrue(String name);

    List<Fruit> findAllByPriceGreaterThanEqualAndIsSoldIsFalse(long price);

    List<Fruit> findAllByPriceLessThanEqualAndIsSoldIsFalse(long price);
}
