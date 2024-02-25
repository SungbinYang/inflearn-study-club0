package me.sungbin.dto.fruit.response;

/**
 * @author : rovert
 * @packageName : me.sungbin.dto.fruit.response
 * @fileName : GetFruitResponseDto
 * @date : 2/25/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/25/24       rovert         최초 생성
 */

public class GetFruitResponseDto {
    private long salesAmount;

    private long notSalesAmount;

    public GetFruitResponseDto(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
