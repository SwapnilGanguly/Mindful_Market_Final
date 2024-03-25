package com.gangulytpoint.mindfulmarket;

public class Item {
    private final int image;
    private final float rating;
    private final int price;
    Item(int image, float rating, int price) {
        this.image = image;
        this.rating = rating;
        this.price = price;
    }
    public int getImage() {
        return image;
    }
    public float getRating() {
        return rating;
    }
    public int getPrice() {
        return price;
    }
}
