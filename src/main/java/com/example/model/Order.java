package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer id;
    private double total;
    private List<Product> itemList = new ArrayList<Product>();

    public Order() {
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public Integer getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public Integer size() {
        return itemList.size();
    }

    public void addToOrder(Product product) {
        itemList.add(product);
        total += product.getPrice();
    }

    public void deleteFromOrder(int number) {
        total -= itemList.get(number).getPrice();
        System.out.println(number);
        itemList.remove(number);
    }
}
