package com.example.final_projectlnt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentCounter extends Fragment {

    TextView number;
    Button plus, minus, res;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public static final String session = "session";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        number = view.findViewById(R.id.tv_num);
        plus = view.findViewById(R.id.plus);
        minus = view.findViewById(R.id.minus);
        res = view.findViewById(R.id.reset);

        pref = getActivity().getSharedPreferences("NUMBER", Context.MODE_PRIVATE);

        String angka = pref.getString("NUMBER", "");
        number.setText(angka);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambah();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kurang();
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    public void tambah(){
        int num = Integer.valueOf(number.getText().toString().trim());
        num = num + 1;
        String temp = String.valueOf(num);
        number.setText(temp);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("NUMBER", temp);
        editor.apply();
    }

    public void kurang(){
        int num = Integer.valueOf(number.getText().toString().trim());
        num = num - 1;
        String res = String.valueOf(num);
        number.setText(res);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("NUMBER", res);
        editor.apply();
    }

    public void reset(){
        int num = Integer.valueOf(number.getText().toString().trim());
        num = 0;
        String res = String.valueOf(num);
        number.setText(res);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("NUMBER", res);
        editor.apply();
    }
}