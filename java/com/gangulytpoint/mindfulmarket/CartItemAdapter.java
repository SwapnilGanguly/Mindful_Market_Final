package com.gangulytpoint.mindfulmarket;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CartItemAdapter extends ArrayAdapter<CartItem> {
    ArrayList<CartItem> items;
    ImageView cartImage;
    TextView cartPrice, cartQuantity;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    CartItemAdapter(@NonNull Context context, ArrayList<CartItem> items) {
        super(context, 0, items);
        this.items = items;
        preferences = getContext().getSharedPreferences("data", 0);
        editor = preferences.edit();
    }
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        CartItem item = getItem(position);
        View layoutView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        if (layoutView != null) {
            cartImage = layoutView.findViewById(R.id.cart_item_image);
            cartPrice = layoutView.findViewById(R.id.cart_item_price);
            cartQuantity = layoutView.findViewById(R.id.cart_item_quantity);
            cartImage.setImageResource(item.getImage());
            cartPrice.setText("Price: ₹ " + item.getPrice() + ".00/-");
            cartQuantity.setText("Quantity: " + item.getQuantity());
        }
        return layoutView;
    }
}
