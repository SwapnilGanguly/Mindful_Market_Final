package com.gangulytpoint.mindfulmarket;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.Objects;

public class SelectedFragment extends DialogFragment {
    Item item;
    String chosenCategory;
    ImageView imageView;
    TextView priceText;
    EditText quantityText;
    LinearLayout cartLayout, rateLayout;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    FragmentManager manager;
    FragmentTransaction transaction;
    SelectedFragment(Item item, String chosenCategory, FragmentManager manager) {
        this.item = item;
        this.chosenCategory = chosenCategory;
        this.manager = manager;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selected, container, false);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        preferences = getContext().getSharedPreferences("data", 0);
        imageView = view.findViewById(R.id.selected_image);
        priceText = view.findViewById(R.id.selected_price);
        quantityText = view.findViewById(R.id.selected_quantity);
        cartLayout = view.findViewById(R.id.selected_cart);
        rateLayout = view.findViewById(R.id.selected_rate);
        imageView.setImageResource(item.getImage());
        priceText.setText("Price: ₹ " + item.getPrice() + ".00/-");
        quantityText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!quantityText.getText().toString().equals(""))
                    priceText.setText("Price: ₹ " + (item.getPrice() * Integer.parseInt(quantityText.getText().toString())) + ".00/-");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        cartLayout.setOnClickListener(v -> {
            editor = preferences.edit();
            Items.populateItems(chosenCategory);
            int pos = -1;
            for (int i = 0; i < Items.items.length; i++) {
                if (Items.items[i].getImage() == item.getImage()) {
                    pos = i;
                    break;
                }
            }
            int n = preferences.getInt("no_of_items", 0);
            editor.putString("category" + (n + 1), chosenCategory);
            editor.putInt("quantity" + (n + 1), Integer.parseInt(quantityText.getText().toString()));
            editor.putInt("position" + (n + 1), pos);
            editor.putInt("no_of_items", (n + 1)).apply();
            editor.apply();
            FancyToast.makeText(requireContext(), "Added to cart", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
            dismiss();
        });
        rateLayout.setOnClickListener(v -> {
            transaction = manager.beginTransaction();
            transaction.add(new RateFragment(), "Rate Fragment").commit();
            dismiss();
        });
    }
}
