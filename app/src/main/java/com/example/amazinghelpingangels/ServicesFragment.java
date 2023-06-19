package com.example.amazinghelpingangels;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ServicesFragment extends Fragment {

    private TextView popular_sevice1, popular_services2;
    private boolean isClicked1 = false;
    private boolean isClicked2 = false;




    public ServicesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        popular_sevice1 = view.findViewById(R.id.popular_sevice1);
        popular_services2 = view.findViewById(R.id.popular_services2);


        //
        popular_sevice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isClicked1) {
                    popular_sevice1.setBackgroundColor(Color.parseColor("#D8D5D0"));
                    popular_sevice1.setTextColor(Color.parseColor("#000000"));

                    isClicked1 = true;
                } else {
                    popular_sevice1.setBackgroundColor(Color.parseColor("#FF5E15"));
                    popular_sevice1.setTextColor(Color.parseColor("#FFFFFF"));
                    setRoundedBackground(popular_sevice1);
                    isClicked1 = false;
                }
            }
        });

        popular_services2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popular_services2.setBackgroundColor(Color.parseColor("#FF5E15"));
                popular_services2.setTextColor(Color.parseColor("#FFFFFF"));

                popular_sevice1.setBackgroundColor(Color.parseColor("#D8D5D0"));
                popular_sevice1.setTextColor(Color.parseColor("#000000"));
                isClicked1 = false;

            }
        });


        return view;
    }

    private void setRoundedBackground(View view) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(Color.parseColor("#FF5E15"));
        gradientDrawable.setCornerRadius(16); // Set the corner radius as desired
        view.setBackground(gradientDrawable);
    }
}