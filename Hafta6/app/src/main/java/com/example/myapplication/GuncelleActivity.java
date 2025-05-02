package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GuncelleActivity extends AppCompatActivity {

    TextView txt_adsoyad_guncelle,txt_mail_guncelle,txt_telefon_guncelle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        txt_adsoyad_guncelle=findViewById(R.id.txt_adsoyad_guncelle);
        txt_mail_guncelle=findViewById(R.id.txt_mail_guncelle);
        txt_telefon_guncelle=findViewById(R.id.txt_telefon_guncelle);

        Müşteri gelenMüşteri= (Müşteri) getIntent().getSerializableExtra("seçilenmüşteri");
        txt_adsoyad_guncelle.setText(gelenMüşteri.getAdsoyad());
        txt_mail_guncelle.setText(gelenMüşteri.getMail());
        txt_telefon_guncelle.setText(gelenMüşteri.getTelefon());

    }
}
