package com.example.final_projectlnt;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentCalculatorVolume extends Fragment {

    EditText panjang, lebar, tinggi1, sisi, tinggi2, jari, tinggi3;
    Button hitung1, hitung2, hitung3;
    TextView hasil1, hasil2, hasil3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator_volume, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        panjang = view.findViewById(R.id.panjang);
        lebar = view.findViewById(R.id.lebar);
        tinggi1 = view.findViewById(R.id.tinggi1);
        sisi = view.findViewById(R.id.sisi);
        tinggi2 = view.findViewById(R.id.tinggi2);
        jari = view.findViewById(R.id.jari);
        tinggi3 = view.findViewById(R.id.tinggi3);

        hitung1 = view.findViewById(R.id.count1);
        hitung2 = view.findViewById(R.id.count2);
        hitung3 = view.findViewById(R.id.count3);

        hasil1 = view.findViewById(R.id.result_balok);
        hasil2 = view.findViewById(R.id.result_piramid);
        hasil3 = view.findViewById(R.id.result_tabung);

        hitung1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek1();
            }
        });

        hitung2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek2();
            }
        });

        hitung3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek3();
            }
        });
    }

    private void cek1(){
        String tes = panjang.getText().toString().trim();
        String tes2 = lebar.getText().toString().trim();
        String tes3 = tinggi1.getText().toString().trim();
//        if(tes.isEmpty()){
//            panjang.setError("Panjang cannot be empty");
//        }
//        if(tes2.isEmpty()){
//            lebar.setError("Lebar cannot be empty");
//        }
//        if(tes3.isEmpty()){
//            tinggi1.setError("Tinggi cannot be empty");
//        }
        if(!tes.isEmpty() && !tes2.isEmpty() && !tes3.isEmpty()){
            double num1 = 0, num2 = 0, num3 = 0, res;
            num1 = Double.valueOf(panjang.getText().toString().trim());
            num2 = Double.valueOf(lebar.getText().toString().trim());
            num3 = Double.valueOf(tinggi1.getText().toString().trim());
            res = num1 * num2 * num3;
            String result = String.valueOf(res);
            hasil1.setText(result);
        }
        else{
            Toast.makeText(getActivity(), "Balok requirement should be filled!", Toast.LENGTH_SHORT).show();
        }
    }

    private void cek2(){
        String tes = sisi.getText().toString().trim();
        String tes2 = tinggi2.getText().toString().trim();
//        if(tes.isEmpty()){
//            sisi.setError("Sisi alas cannot be empty");
//        }
//        if(tes2.isEmpty()){
//            tinggi2.setError("Tinggi cannot be empty");
//        }
        if(!tes.isEmpty() && !tes2.isEmpty()) {
            double bil1, bil2, hasil;
            bil1 = Double.valueOf(sisi.getText().toString().trim());
            bil2 = Double.valueOf(tinggi2.getText().toString().trim());
            hasil = (bil1 * bil1 * bil2) / 3;
            String hasill = String.valueOf(hasil);
            hasil2.setText(hasill);
        }
        else{
            Toast.makeText(getActivity(), "Piramid requirement should be filled!", Toast.LENGTH_SHORT).show();
        }
    }
    private void cek3(){
        String tes = jari.getText().toString().trim();
        String tes2 = tinggi3.getText().toString().trim();
//        if(tes.isEmpty()){
//            jari.setError("Jari-jari alas cannot be empty");
//        }
//        if(tes2.isEmpty()){
//            tinggi3.setError("Tinggi cannot be empty");
//        }
        if(!tes.isEmpty() && !tes2.isEmpty()){
            double number1, number2, res;
            number1 = Double.valueOf(jari.getText().toString().trim());
            number2 = Double.valueOf(tinggi3.getText().toString().trim());
            res = (22 * number1 * number1 * number2) / 7;
            String result = String.valueOf(res);
            hasil3.setText(result);
        }
        else{
            Toast.makeText(getActivity(), "Tabung requirement should be filled!", Toast.LENGTH_SHORT).show();
        }
    }

}