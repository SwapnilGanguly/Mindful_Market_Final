package com.gangulytpoint.mindfulmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Items extends AppCompatActivity {
    Bundle extras;
    String chosenCategory;
    public static Item[] items;
    GridView gridView;
    ArrayList<Item> arrayList;
    TextView topbar_text;
    ImageView cart;
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        cart = findViewById(R.id.items_cart);
        extras = getIntent().getExtras();
        manager = getSupportFragmentManager();
        cart.setOnClickListener(view -> {
            transaction = manager.beginTransaction();
            transaction.add(new CartFragment(chosenCategory), "Cart").commit();

        });
        chosenCategory = extras.getString("category");
        topbar_text = findViewById(R.id.items_topbar_text);
        topbar_text.setText(chosenCategory);
        populateItems(chosenCategory);
        FragmentManager manager = getSupportFragmentManager();
        gridView = findViewById(R.id.items_grid);
        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(items));
        ItemAdapter adapter = new ItemAdapter(this, arrayList, chosenCategory, manager);
        gridView.setAdapter(adapter);
    }
    public static void populateItems(String chosenCategory) {
        switch (Objects.requireNonNull(chosenCategory)) {
            case "Shirts":
                items = new Item[] {
                        new Item(R.drawable.shirt1, 4.9f, 699),
                        new Item(R.drawable.shirt2, 4.8f, 799),
                        new Item(R.drawable.shirt3, 4.9f, 499),
                        new Item(R.drawable.shirt4, 5.0f, 749),
                        new Item(R.drawable.shirt5, 4.8f, 649),
                        new Item(R.drawable.shirt6, 4.9f, 799),
                        new Item(R.drawable.shirt7, 5.0f, 649),
                        new Item(R.drawable.shirt8, 4.9f, 699)
                };
                break;
            case "Trousers":
                items = new Item[] {
                        new Item(R.drawable.trouser_1, 4.9f, 1699),
                        new Item(R.drawable.trouser_2, 4.8f, 1799),
                        new Item(R.drawable.trouser_3, 4.9f, 1499),
                        new Item(R.drawable.trouser_4, 5.0f, 1749),
                        new Item(R.drawable.trouser_5, 4.8f, 1649),
                        new Item(R.drawable.trouser_6, 4.9f, 1799),
                        new Item(R.drawable.trouser_7, 5.0f, 1649),
                };
                break;
            case "T-Shirts":
                items = new Item[] {
                        new Item(R.drawable.tshirt1, 4.9f, 699),
                        new Item(R.drawable.tshirt2, 4.8f, 799),
                        new Item(R.drawable.tshirt3, 4.9f, 499),
                        new Item(R.drawable.tshirt4, 5.0f, 749),
                        new Item(R.drawable.tshirt5, 4.8f, 649),
                        new Item(R.drawable.tshirt6, 4.9f, 799),
                        new Item(R.drawable.tshirt7, 5.0f, 649),
                        new Item(R.drawable.tshirt8, 4.9f, 699),
                        new Item(R.drawable.tshirt9, 4.9f, 699),
                        new Item(R.drawable.tshirt10, 4.9f, 699),
                        new Item(R.drawable.tshirt11, 4.9f, 699),
                        new Item(R.drawable.tshirt12, 4.9f, 699),
                        new Item(R.drawable.tshirt13, 4.9f, 699),
                        new Item(R.drawable.tshirt14, 4.9f, 699),
                        new Item(R.drawable.tshirt15, 4.9f, 699)
                };
                break;
            case "Jeans":
                items = new Item[] {
                        new Item(R.drawable.jeans_1, 4.9f, 1699),
                        new Item(R.drawable.jeans_3, 4.8f, 1799),
                        new Item(R.drawable.jeans_4, 4.9f, 1399),
                        new Item(R.drawable.jeans_5, 5.0f, 1749),
                        new Item(R.drawable.jeans_6, 4.8f, 1449)
                };
                break;
            case "Jerseys":
                items = new Item[] {
                        new Item(R.drawable.jersey_kkr, 4.9f, 699),
                        new Item(R.drawable.jersey_mi, 4.8f, 799),
                        new Item(R.drawable.jersey_csk, 4.8f, 799),
                        new Item(R.drawable.jersey_rcb, 4.8f, 799),
                        new Item(R.drawable.jersey_atletico, 4.9f, 499),
                        new Item(R.drawable.jersey_barca, 5.0f, 749),
                        new Item(R.drawable.jersey_real_madrid, 4.8f, 649),
                        new Item(R.drawable.jersey_manu, 4.8f, 649),
                        new Item(R.drawable.jersey_argentina, 4.8f, 649),
                        new Item(R.drawable.jersey_brazil, 4.8f, 649),
                        new Item(R.drawable.jersey_eb, 4.9f, 799),
                        new Item(R.drawable.jersey_mb, 5.0f, 649)
                };
                break;
            case "Bags":
                items = new Item[] {
                        new Item(R.drawable.bags1, 4.9f, 699),
                        new Item(R.drawable.bags2, 4.8f, 799),
                        new Item(R.drawable.bags3, 4.9f, 499),
                        new Item(R.drawable.bags4, 5.0f, 749),
                        new Item(R.drawable.bags5, 4.8f, 649),
                        new Item(R.drawable.bags6, 4.9f, 799),
                        new Item(R.drawable.bags7, 5.0f, 649),
                        new Item(R.drawable.bags8, 4.9f, 699),
                        new Item(R.drawable.bags9, 4.9f, 699),
                        new Item(R.drawable.bags10, 4.9f, 699),
                        new Item(R.drawable.bags11, 4.9f, 699)
                };
                break;
            case "Watches":
                items = new Item[] {
                        new Item(R.drawable.watch1, 4.9f, 699),
                        new Item(R.drawable.watch2, 4.8f, 799),
                        new Item(R.drawable.watch3, 4.9f, 499),
                        new Item(R.drawable.watch4, 5.0f, 749),
                        new Item(R.drawable.watch5, 4.8f, 649),
                        new Item(R.drawable.watch6, 4.9f, 799),
                        new Item(R.drawable.watch7, 5.0f, 649),
                        new Item(R.drawable.watch8, 4.9f, 699),
                        new Item(R.drawable.watch9, 4.9f, 699),
                        new Item(R.drawable.watch10, 4.9f, 699),
                        new Item(R.drawable.watch11, 4.9f, 699),
                        new Item(R.drawable.watch12, 4.9f, 699),
                        new Item(R.drawable.watch13, 4.9f, 699),
                        new Item(R.drawable.watch14, 4.9f, 699),
                        new Item(R.drawable.watch15, 4.9f, 699)
                };
                break;
        }
    }
}