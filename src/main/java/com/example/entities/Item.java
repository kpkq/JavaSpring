package com.example.entities;


import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private Float price;

    public Item() {
    }

    public Item(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Item(Item item) {
        this.id = item.id;
        this.name = item.name;
        this.price = item.price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(
                "Item[id=%d, name='%s', price='%s']",
                id, name, price);
    }
}
