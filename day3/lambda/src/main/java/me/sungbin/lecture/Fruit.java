package me.sungbin.lecture;

public class Fruit {

    private final String name;

    private final int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isApple() {
        return true;
    }
}
