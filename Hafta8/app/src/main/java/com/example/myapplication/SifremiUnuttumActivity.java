package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SifremiUnuttumActivity extends AppCompatActivity {


    TextView txt_mail_su;
    Button btn_su;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifremi_unuttum);

        txt_mail_su=findViewById(R.id.txt_maii_şifremi_unuttum);
        btn_su=findViewById(R.id.btn_şifre_reset);


        FirebaseAuth fba=FirebaseAuth.getInstance();

        btn_su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fba.sendPasswordResetEmail(txt_mail_su.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Intent login_intent=new Intent(SifremiUnuttumActivity.this, LoginActivity.class);
                                    startActivity(login_intent);
                                }
                            }
                        });
            }
        });
    }
}
