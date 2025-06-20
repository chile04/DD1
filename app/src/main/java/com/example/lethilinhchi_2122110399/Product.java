package com.example.lethilinhchi_2122110399;

public class Product {
    private String name;
    private int imageResId;
    private int price;

    public Product(String name, int imageResId, int price) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getPrice() {
        return price;
    }
}

