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

public class FragmentCalculatorArea extends Fragment {

    EditText sisi, sisi2, alas, tinggi, jari;
    Button count1, count2, count3;
    TextView result1, result2, result3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator_area, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sisi = view.findViewById(R.id.sisi1);
        sisi2 = view.findViewById(R.id.sisi2);
        alas = view.findViewById(R.id.alas);
        tinggi = view.findViewById(R.id.tinggi);
        jari = view.findViewById(R.id.jari);

        count1 = view.findViewById(R.id.count1);
        count2 = view.findViewById(R.id.count2);
        count3 = view.findViewById(R.id.count3);

        result1 = view.findViewById(R.id.result_persegi);
        result2 = view.findViewById(R.id.result_segitiga);
        result3 = view.findViewById(R.id.result_lingkaran);

        count1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek1();
            }
        });

        count2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek2();
            }
        });

        count3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek3();
            }
        });
    }

    private void cek1(){
        String tes = sisi.getText().toString().trim();
        String tes2 = sisi2.getText().toString().trim();
//        if(tes.isEmpty()){
//            sisi.setError("Sisi cannot be empty");
//        }
//        if(tes2.isEmpty()){
//            sisi2.setError("Sisi2 cannot be empty");
//        }
        if(!tes.isEmpty() && !tes2.isEmpty()){
            double num1, num2, res;
            num1 = Double.valueOf(sisi.getText().toString().trim());
            num2 = Double.valueOf(sisi2.getText().toString().trim());
            res = num1 * num2;
            String result = String.valueOf(res);
            result1.setText(result);
        }
        else{
            Toast.makeText(getActivity(), "Persegi requirement should be filled!", Toast.LENGTH_SHORT).show();
        }
    }

    private void cek2(){
        String tes = alas.getText().toString().trim();
        String tes2 = tinggi.getText().toString().trim();
//        if(tes.isEmpty()){
//            alas.setError("Alas cannot be empty");
//        }
//        if(tes2.isEmpty()){
//            tinggi.setError("Tinggi cannot be empty");
//        }
        if(!tes.isEmpty() && !tes2.isEmpty()){
            double bil1, bil2, hasil;
            bil1 = Double.valueOf(alas.getText().toString().trim());
            bil2 = Double.valueOf(tinggi.getText().toString().trim());
            hasil = (bil1 * bil2) / 2;
            String hasill = String.valueOf(hasil);
            result2.setText(hasill);
        }
        else{
            Toast.makeText(getActivity(), "Segitiga requirement should be filled!", Toast.LENGTH_SHORT).show();
        }
    }

    private void cek3(){
        String tes = jari.getText().toString().trim();
//        if(tes.isEmpty()){
//            jari.setError("Jari-jari cannot be empty");
//        }
        if(!tes.isEmpty()){
            double number, res;
            number = Double.valueOf(jari.getText().toString().trim());
            res = (22 * number * number) / 7;
            String result = String.valueOf(res);
            result3.setText(result);
        }
        else{
            Toast.makeText(getActivity(), "Lingkaran requirement should be filled!", Toast.LENGTH_SHORT).show();
        }
    }
}