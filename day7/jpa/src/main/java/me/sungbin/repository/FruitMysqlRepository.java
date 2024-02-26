package me.sungbin.repository;

import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : rovert
 * @packageName : me.sungbin.repository
 * @fileName : FruitMysqlRepository
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */
@Repository
public class FruitMysqlRepository implements FruitJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public FruitMysqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruitInfo(Fruit fruit) {
        log.info("[FruitMysqlRepository] - saveFruitInfo");
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";

        this.jdbcTemplate.update(sql, fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
    }

    @Override
    public void updateFruitInfo(long id) {
        log.info("[FruitMysqlRepository] - updateFruitInfo");
        String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public GetFruitResponseDto getFruitInfo(String name) {
        log.info("[FruitMysqlRepository] - getFruitInfo");
        String sql = "SELECT is_sold, SUM(price) AS total FROM fruit WHERE name = ? GROUP BY is_sold";

        Map<Boolean, Long> aggregatedData = jdbcTemplate.query(sql, new Object[]{name}, rs -> {
            HashMap<Boolean, Long> map = new HashMap<>();
            while (rs.next()) {
                map.put(rs.getBoolean("is_sold"), rs.getLong("total"));
            }
            return map;
        });

        long salesAmount = Objects.requireNonNull(aggregatedData).getOrDefault(true, 0L);
        long notSalesAmount = Objects.requireNonNull(aggregatedData).getOrDefault(false, 0L);

        return new GetFruitResponseDto(salesAmount, notSalesAmount);
    }

    @Override
    public boolean isNotExistsFruitInfo(long id) {
        String readSQL = "SELECT * FROM fruit WHERE id = ?";

        return jdbcTemplate.query(readSQL, (rs, rowNum) -> 0, id).isEmpty();
    }
}
