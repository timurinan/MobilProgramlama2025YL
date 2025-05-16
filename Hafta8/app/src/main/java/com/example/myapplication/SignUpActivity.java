package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    TextView txt_mail_signup,txt_şifre_signup,txt_şifre_signup2;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txt_mail_signup=findViewById(R.id.txt_mail_signup);
        txt_şifre_signup=findViewById(R.id.txt_şifre_signup);
        txt_şifre_signup2=findViewById(R.id.txt_şifre_signup2);
        btn_signup=findViewById(R.id.btn_signup);

        FirebaseAuth fba=FirebaseAuth.getInstance();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_şifre_signup.getText().toString().equals(txt_şifre_signup2.getText().toString())){
                    Toast.makeText(SignUpActivity.this, "Şifreler Uygundur", Toast.LENGTH_SHORT).show();
                    fba.createUserWithEmailAndPassword(txt_mail_signup.getText().toString(),txt_şifre_signup.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    fba.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(SignUpActivity.this, "Mail Gönderildi", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(SignUpActivity.this, "Mail Gönderilemedi", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            });
                }else{
                    Toast.makeText(SignUpActivity.this, "Şifreler Uyumsuzdur", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}