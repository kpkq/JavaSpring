package com.example.entities;

import java.util.List;

public class Order {
    private Integer id;
    private List<Item> itemList;
    private double total = 0;

    public Order() {
    }

    public Order(Item item) {
        this.itemList.add(item);
        this.total+=item.getPrice();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addTotal(Float price) {
        this.total += price;
    }

    public void addItemToList(Item item) {
        this.itemList.add(item);
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
