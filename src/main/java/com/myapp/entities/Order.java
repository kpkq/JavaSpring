package com.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "store_table")
// сущность Заказ
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String stringItemList;
    private double total;

    public Order() {
        this.total = 0;
    }

    public void addTotal(Float price) {
        this.total += price;
    }

    public void subTotal(Float price) { this.total -= price; }

    public void setStringItemList(String itemList) {
        this.stringItemList = itemList;
    }

}
