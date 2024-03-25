package com.gangulytpoint.mindfulmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ItemsCategory extends AppCompatActivity {
    CardView shirts, trousers, tshirts, jeans, jerseys, bags, watches;
    ImageView cartImage;
    String chosenCategory;
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_category);
        manager = getSupportFragmentManager();
        cartImage = findViewById(R.id.items_category_cart);
        shirts = findViewById(R.id.shirts);
        trousers = findViewById(R.id.trousers);
        tshirts = findViewById(R.id.tshirts);
        jeans = findViewById(R.id.jeans);
        jerseys = findViewById(R.id.jerseys);
        bags = findViewById(R.id.bags);
        watches = findViewById(R.id.watches);
        cartImage.setOnClickListener(v -> {
            transaction = manager.beginTransaction();
            transaction.add(new CartFragment(""), "Cart").commit();
        });
        shirts.setOnClickListener(v -> {
            goToItems("Shirts");
        });
        trousers.setOnClickListener(v -> {
            goToItems("Trousers");
        });
        tshirts.setOnClickListener(v -> {
            goToItems("T-Shirts");
        });
        jeans.setOnClickListener(v -> {
            goToItems("Jeans");
        });
        jerseys.setOnClickListener(v -> {
            goToItems("Jerseys");
        });
        bags.setOnClickListener(v -> {
            goToItems("Bags");
        });
        watches.setOnClickListener(v -> {
            goToItems("Watches");
        });
    }
    private void goToItems(String item) {
        chosenCategory = item;
        Intent intent = new Intent(getApplicationContext(), Items.class);
        intent.putExtra("category", item);
        startActivity(intent);
    }
}