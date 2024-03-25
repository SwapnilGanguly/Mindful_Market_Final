package com.gangulytpoint.mindfulmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {
    ImageView item_image;
    TextView item_rating, item_price;
    String chosenCategory;
    FragmentManager manager;
    FragmentTransaction transaction;
    ItemAdapter(@NonNull Context context, ArrayList<Item> items, String chosenCategory, FragmentManager manager) {
        super(context, 0, items);
        this.chosenCategory = chosenCategory;
        this.manager = manager;
    }
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Item item = getItem(position);
        View layoutView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        if (layoutView != null) {
            item_image = layoutView.findViewById(R.id.item_image);
            item_rating = layoutView.findViewById(R.id.item_rating);
            item_price = layoutView.findViewById(R.id.item_price);
            item_image.setImageResource(item.getImage());
            item_rating.setText(Float.toString(item.getRating()));
            item_price.append(item.getPrice() + ".00/-");
            layoutView.setOnClickListener(v -> {
                transaction = manager.beginTransaction();
                transaction.add(new SelectedFragment(item, chosenCategory, manager), "Selected Item").commit();
            });
        }
        return layoutView;
    }
}
