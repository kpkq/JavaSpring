package com.example.item;


import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer price;

    public Item() {
    }

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Item[id=%d, name='%s', price='%s']",
                id, name, price);
    }
}
