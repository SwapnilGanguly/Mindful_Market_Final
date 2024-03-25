package com.gangulytpoint.mindfulmarket;

public class CartItem {
    private final int image;
    private final int quantity;
    private final int price;
    CartItem(int image, int quantity, int price) {
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }
    public int getImage() {
        return image;
    }
    public int getQuantity() {
        return quantity;
    }
    public int getPrice() {
        return price;
    }
}
