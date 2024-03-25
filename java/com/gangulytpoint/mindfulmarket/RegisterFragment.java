package com.gangulytpoint.mindfulmarket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.shashank.sony.fancytoastlib.FancyToast;

public class RegisterFragment extends DialogFragment {
    EditText etName, etPass;
    Button register;
    String name, password;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        etName = view.findViewById(R.id.register_name);
        etPass = view.findViewById(R.id.register_pass);
        register = view.findViewById(R.id.register_registerbtn);
        register.setOnClickListener(v -> {
            name = etName.getText().toString();
            password = etPass.getText().toString();
            if (!name.equals("") && !password.equals("")) {
                preferences = getContext().getSharedPreferences("data", 0);
                editor = preferences.edit();
                editor.putString("name", name);
                editor.putString("password", password).apply();
                FancyToast.makeText(requireContext(), "Registered Successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                getContext().startActivity(new Intent(getContext(), ItemsCategory.class));
                dismiss();
            }
            else {
                FancyToast.makeText(requireContext(), "The fields should not be empty", FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
            }
        });
    }
}
