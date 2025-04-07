package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KarsilamaActivity extends AppCompatActivity {

    TextView txt_multiline;

    Button btn_GeriDön;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karsilama);

        btn_GeriDön=findViewById(R.id.btn_geriDön);
        txt_multiline=findViewById(R.id.txt_multiline);

//        String adsoyad=getIntent().getStringExtra("isim");
//        String mail=getIntent().getStringExtra("mail");
//        String telefon=getIntent().getStringExtra("tel");

        Müşteri gelenmüşteri= (Müşteri) getIntent().getSerializableExtra("müşterinesnesi");
        txt_multiline.setText("Sayın: "+gelenmüşteri.getAdsoyad()+"\n"+"Mail adresiniz:"+gelenmüşteri.getMail()+"\n"+
                "Telefonunuz:"+gelenmüşteri.getTelefon()+"\n Bilgileriniz alınmıştır, en kısa sürede dönüş sağlanacaktır...");

        btn_GeriDön.setOnClickListener(v -> geriDön());
    }

    private void geriDön(){
        Intent intent=new Intent(KarsilamaActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
