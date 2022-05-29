package com.example.final_projectlnt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText id, email, name, password, password2;
    private Button btnRegister;
    private TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        id = findViewById(R.id.et_registerId);
        email = findViewById(R.id.et_registerEmail);
        name = findViewById(R.id.et_registerName);
        password = findViewById(R.id.et_registerPassword);
        password2 = findViewById(R.id.et_registerPassword2);
        btnRegister = findViewById(R.id.btn_register);
        loginText = findViewById(R.id.tv_toLogin);

        btnRegister.setOnClickListener(view -> {
            register();
        });

        loginText.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });

    }

    private void register(){
        String ID = id.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String user = name.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String pass2 = password2.getText().toString().trim();

        if(ID.isEmpty()){
            id.setError("ID Number cannot be empty!");
        }

        if(mail.isEmpty()){
            email.setError("Email cannot be empty!");
        }

        if(user.isEmpty()){
            name.setError("Name cannot be empty!");
        }else if(user.length() <= 4){
            name.setError("Name must be more than 5 character");
        }

        if(pass.isEmpty()){
            password.setError("Password cannot be empty!");
        }

        if(pass2.isEmpty()){
            password2.setError("Confirmation password cannot be empty!");
        }else if(!(pass2.equals(pass))){
            password2.setError("Confirmation password invalid");
        }

        if(!ID.isEmpty() && !user.isEmpty() && user.length()>4 && !mail.isEmpty() && !pass.isEmpty() && !pass2.isEmpty() && pass2.equals(pass)){
            mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Data data = new Data(ID, mail, user, pass, pass2);
                        FirebaseDatabase
                                .getInstance()
                                .getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(data)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Register Failed: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

}