package com.gangulytpoint.mindfulmarket;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;

public class CartFragment extends DialogFragment {
    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;
    GridView gridView;
    TextView amountText, place_order, clear_cart, nothing;
    String chosenCategory;
    static ArrayList<CartItem> arrayList;
    static int amount;
    CartFragment(String chosenCategory) {
        this.chosenCategory = chosenCategory;
        amount = 0;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        gridView = view.findViewById(R.id.cart_recyclerview);
        amountText = view.findViewById(R.id.cart_amount);
        place_order = view.findViewById(R.id.place_order);
        clear_cart = view.findViewById(R.id.clear_cart);
        nothing = view.findViewById(R.id.cart_nothing);
        preferences = getContext().getSharedPreferences("data", 0);
        editor = preferences.edit();
        arrayList = new ArrayList<>();
        int n = preferences.getInt("no_of_items", 0);
        if (n == 0) {
            gridView.setVisibility(View.GONE);
            amountText.setVisibility(View.GONE);
            place_order.setVisibility(View.GONE);
            clear_cart.setVisibility(View.GONE);
        }
        else {
            nothing.setVisibility(View.GONE);
            fillCart(n);
            CartItemAdapter cartItemAdapter = new CartItemAdapter(getContext(), arrayList);
            gridView.setAdapter(cartItemAdapter);
            amountText.setText("Amount: ₹ " + amount + ".00/-");
            clear_cart.setOnClickListener(v -> {
                editor.putInt("no_of_items", 0).apply();
                FancyToast.makeText(getContext(), "Cart has been cleared", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
                dismiss();
            });
            place_order.setOnClickListener(v -> {
                editor.putInt("no_of_items", 0).apply();
                FancyToast.makeText(getContext(), "Order placed successfully", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
                dismiss();
            });
        }
    }
    public static void fillCart(int n) {
        arrayList.clear();
        for (int i = 1; i <= n; i++) {
            String category = preferences.getString("category" + i, "");
            if (!category.equals("")) {
                Items.populateItems(category);
            }
            int quantity = preferences.getInt("quantity" + i, -1);
            int position = preferences.getInt("position" + i, -1);
            if (position != -1) {
                Item item = Items.items[position];
                CartItem cartItem = new CartItem(item.getImage(), quantity, item.getPrice() * quantity);
                arrayList.add(cartItem);
                amount += cartItem.getPrice();
            }
        }
    }
}
