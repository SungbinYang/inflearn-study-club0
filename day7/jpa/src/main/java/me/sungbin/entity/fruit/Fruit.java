package me.sungbin.entity.fruit;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

/**
 * @author : rovert
 * @packageName : me.sungbin.entity.fruit
 * @fileName : Fruit
 * @date : 2/26/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/26/24       rovert         최초 생성
 */

@Entity
public class Fruit {

    @Id
    @Comment("Fruit 테이블의 Primary key")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate warehousingDate;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private boolean isSold = false;

    public Fruit() {
    }

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public Fruit(String name, LocalDate warehousingDate, Long price, boolean isSold) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
    }

    public Fruit(Long id, String name, LocalDate warehousingDate, Long price, boolean isSold) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = isSold;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void updateSoldInfo(boolean isSold) {
        this.isSold = isSold;
    }
}
