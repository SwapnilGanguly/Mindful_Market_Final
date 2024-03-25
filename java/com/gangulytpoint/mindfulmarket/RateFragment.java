package com.gangulytpoint.mindfulmarket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.shashank.sony.fancytoastlib.FancyToast;

public class RateFragment extends DialogFragment {
    RatingBar ratingBar;
    TextView submit;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rate, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        ratingBar = view.findViewById(R.id.rating);
        submit = view.findViewById(R.id.rate_submit);
        submit.setOnClickListener(v -> {
            FancyToast.makeText(getContext(), "Rating submitted", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
            dismiss();
        });
    }
}
