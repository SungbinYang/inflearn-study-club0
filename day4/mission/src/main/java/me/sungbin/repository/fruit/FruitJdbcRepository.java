package me.sungbin.repository.fruit;

import me.sungbin.dto.fruit.response.GetFruitResponseDto;
import me.sungbin.entity.fruit.Fruit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : rovert
 * @packageName : me.sungbin.repository.fruit
 * @fileName : FruitJdbcRepository
 * @date : 2/22/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/22/24       rovert         최초 생성
 */
@Repository
public class FruitJdbcRepository implements FruitRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruitInfo(Fruit fruit) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, fruit.getName(), fruit.getWarehousingDate(), fruit.getPrice());
    }

    @Override
    public void updateFruitInfo(long id) {
        validate(id);

        String sql = "UPDATE fruit SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public GetFruitResponseDto getFruitInfo(String name) {
//        String salesAmountSQL = "SELECT price FROM fruit WHERE name = ? AND is_sold = 1";
//        List<Long> salesAmounts = jdbcTemplate.query(salesAmountSQL, new Object[]{name}, (rs, rowNum) -> rs.getLong("price"));
//        long salesAmount = salesAmounts.stream().reduce(0L, Long::sum);
//
//        String notSalesAmountSQL = "SELECT price FROM fruit WHERE name = ? AND is_sold = 0";
//        List<Long> notSalesAmounts = jdbcTemplate.query(notSalesAmountSQL, new Object[]{name}, (rs, rowNum) -> rs.getLong("price"));
//        long notSalesAmount = notSalesAmounts.stream().reduce(0L, Long::sum);
        long salesAmount = 0;
        long notSalesAmount = 0;

        String sql = "SELECT SUM(price) as total, is_sold FROM fruit WHERE name = ? GROUP BY is_sold";

        Map<Boolean, Long> aggregatedData = jdbcTemplate.query(sql, new Object[]{name}, rs -> {
            HashMap<Boolean, Long> map = new HashMap<>();
            while (rs.next()) {
                map.put(rs.getBoolean("is_sold"), rs.getLong("total"));
            }
            return map;
        });

        if (aggregatedData.containsKey(true)) {
            salesAmount = aggregatedData.get(true);
        }
        if (aggregatedData.containsKey(false)) {
            notSalesAmount = aggregatedData.get(false);
        }

        validateGetFruitAmount(salesAmount, notSalesAmount);

        return new GetFruitResponseDto(salesAmount, notSalesAmount);
    }

    /**
     * 과일이 존재하지 않을 때
     * @param salesAmount
     * @param notSalesAmount
     */
    private void validateGetFruitAmount(long salesAmount, long notSalesAmount) {
        if (salesAmount == 0L && notSalesAmount == 0L) {
            throw new IllegalArgumentException("존재하는 과일이 없습니다.");
        }
    }

    /**
     * 존재하지 않는 과일정보가 있을 것을 대비해 DB에 id값으로 조회 후, true false 반환
     * @param id
     * @return
     */
    private boolean isNotExistsFruitInfo(long id) {
        String readSQL = "SELECT * FROM fruit WHERE id = ?";

        return jdbcTemplate.query(readSQL, (rs, rowNum) -> 0, id).isEmpty();
    }

    /**
     * 존재하지 않는 과일정보를 접근할 경우 Exception 발생
     * @param id
     */
    private void validate(long id) {
        if (isNotExistsFruitInfo(id)) {
            throw new IllegalArgumentException("존재하는 과일정보가 없습니다.");
        }
    }
}
