package com.example.pcwebshop;

public class Item {

    private String id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String imageUrl;        // <-- Lokális drawable név (pl. "eger")
    private String category;
    private String specifications;

    // Konstruktor
    public Item(String id, String name, String description, double price, int stockQuantity,
                String imageUrl, String category, String specifications) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.category = category;
        this.specifications = specifications;
    }

    // Getterek
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getSpecifications() {
        return specifications;
    }

    // (Setterek csak akkor kellenek, ha módosítani akarod az értékeket)
}
