package com.example.model;


public class Product {
    private Integer id;
    private String name;
    private double price;


    public Product() {
    }
    public Product(Integer id, String name, double price) { // класс конкретного продукта
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
