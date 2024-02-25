package me.sungbin.entity.fruit;

import java.time.LocalDate;

/**
 * @author : rovert
 * @packageName : me.sungbin.controller.fruit
 * @fileName : Fruit
 * @date : 2/25/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/25/24       rovert         최초 생성
 */
public class Fruit {

    private long id;

    private String name;

    private LocalDate warehousingDate;

    private long price;

    private boolean isSold;

    public Fruit() {
    }

    public Fruit(String name, LocalDate warehousingDate, long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public Fruit(String name, LocalDate warehousingDate, long price, boolean isSold) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
    }

    public Fruit(long id, String name, LocalDate warehousingDate, long price, boolean isSold) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }
}
