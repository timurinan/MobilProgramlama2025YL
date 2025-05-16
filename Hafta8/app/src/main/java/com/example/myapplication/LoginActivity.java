package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView txt_mail_login,txt_şifre_login,txt_kayıt_login,txt_şifremiunuttum_login;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_mail_login=findViewById(R.id.txt_mail_login);
        txt_şifre_login=findViewById(R.id.txt_şifre_login);
        txt_kayıt_login=findViewById(R.id.txt_kayıt_login);
        txt_şifremiunuttum_login=findViewById(R.id.txt_şifremiunuttum_login);
        btn_login=findViewById(R.id.btn_login);

        FirebaseAuth fba=FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fba.signInWithEmailAndPassword(txt_mail_login.getText().toString(),txt_şifre_login.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()&& fba.getCurrentUser().isEmailVerified()){
                                    Toast.makeText(LoginActivity.this, "Geçerli Kullanıcı", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(LoginActivity.this, "Geçerli Kullanıcı Değil", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        txt_kayıt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup_intent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup_intent);
            }
        });

        txt_şifremiunuttum_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup_intent=new Intent(LoginActivity.this, SifremiUnuttumActivity.class);
                startActivity(signup_intent);
            }
        });
    }
}