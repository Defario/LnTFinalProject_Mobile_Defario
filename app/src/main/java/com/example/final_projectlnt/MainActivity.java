package com.example.final_projectlnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnLogout;
//    Button btnCounter,btnArea, btnVolume;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Adapter adapter;

    private static final String TAG = "Main Activity";

    private FirebaseUser user;
    private DatabaseReference dRef;
    private String userID;
    private TextView toolsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        toolsName =findViewById(R.id.tv_toolsUser);
//
//        user = FirebaseAuth.getInstance().getCurrentUser();
//        dRef = FirebaseDatabase.getInstance().getReference("Users");
//        userID = user.getUid();

//        dRef.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Data dataProfile = snapshot.getValue(Data.class);
//                if(dataProfile != null){
//                    String username = dataProfile.getName();
//
//                    toolsName.setText(username);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(view -> {
            logout();
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);

        setUpViewPager(viewPager);
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }


    public void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    private void  setUpViewPager(ViewPager viewPager){
        if(adapter == null){
            adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new FragmentCounter(), "Counter");
            adapter.addFragment(new FragmentCalculatorArea(), "Area");
            adapter.addFragment(new FragmentCalculatorVolume(), "Volume");
            viewPager.setAdapter(adapter);
        }
    }


}