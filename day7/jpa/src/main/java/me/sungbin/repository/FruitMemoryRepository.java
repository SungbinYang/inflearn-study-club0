package me.sungbin.repository;

import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : rovert
 * @packageName : me.sungbin.repository
 * @fileName : FruitMemoryRepository
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */

@Primary
@Repository
public class FruitMemoryRepository implements FruitJdbcRepository {

    private final List<Fruit> fruits = new ArrayList<>();

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public void saveFruitInfo(Fruit fruit) {
        log.info("[FruitMemoryRepository] - saveFruitInfo");
        fruits.add(fruit);

        System.out.println(fruits.get(0).getId());
    }

    @Override
    public void updateFruitInfo(long id) {
        log.info("[FruitMemoryRepository] - updateFruitInfo");
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            if (fruit.getId() == id) {
                // Assuming Fruit class has an appropriate constructor to handle this case
                Fruit updatedFruit = new Fruit(fruit.getId(), fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice(), true);
                fruits.set(i, updatedFruit);
                break;
            }
        }

        System.out.println(fruits);
    }

    @Override
    public GetFruitResponseDto getFruitInfo(String name) {
        log.info("[FruitMemoryRepository] - getFruitInfo");
        List<Fruit> filteredFruits = fruits.stream()
                .filter(fruit -> fruit.getName().equals(name))
                .toList();

        long salesAmount = filteredFruits.stream()
                .filter(Fruit::isSold)
                .mapToLong(Fruit::getPrice)
                .sum();

        long notSalesAmount = filteredFruits.stream()
                .filter(fruit -> !fruit.isSold())
                .mapToLong(Fruit::getPrice)
                .sum();

        System.out.println(fruits);

        return new GetFruitResponseDto(salesAmount, notSalesAmount);
    }

    @Override
    public boolean isNotExistsFruitInfo(long id) {
        return fruits.stream().noneMatch(fruit -> fruit.getId() == id);
    }

}
