package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EkleActivity extends AppCompatActivity {

    TextView txt_adsoyad_ekle,txt_mail_ekle,txt_telefon_ekle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        txt_adsoyad_ekle=findViewById(R.id.txt_adsoyad_ekle);
        txt_mail_ekle=findViewById(R.id.txt_mail_ekle);
        txt_telefon_ekle=findViewById(R.id.txt_telefon_ekle);
    }
}
