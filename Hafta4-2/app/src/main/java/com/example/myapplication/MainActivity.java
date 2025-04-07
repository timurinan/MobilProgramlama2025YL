package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_adsoyad, txt_telefon, txt_mail;
    Button btn_kaydol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_adsoyad=findViewById(R.id.txt_adsoyad);
        txt_mail=findViewById(R.id.txt_mail);
        txt_telefon=findViewById(R.id.txt_telefon);

        btn_kaydol=findViewById(R.id.btn_Kaydol);

        btn_kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txt_adsoyad.getText())){
                    Toast.makeText(MainActivity.this, "Ad-Soyad Alanı Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                }else{
                    if(!Patterns.EMAIL_ADDRESS.matcher(txt_mail.getText()).matches()){
                        Toast.makeText(MainActivity.this, "Mail uygun formatta değil...", Toast.LENGTH_SHORT).show();
                    }else{
                        if(!PhoneNumberUtils.isGlobalPhoneNumber(txt_telefon.getText().toString())){
                            Toast.makeText(MainActivity.this, "Telefon Numarası Uygun Formatta Olmalıdır", Toast.LENGTH_SHORT).show();
                        }else{
                            String adsoyad=txt_adsoyad.getText().toString();
                            String mail=txt_mail.getText().toString();
                            String telefon=txt_telefon.getText().toString();
                            Intent intent=new Intent(MainActivity.this, KarsilamaActivity.class);
//                            intent.putExtra("isim",adsoyad);
//                            intent.putExtra("mail",mail);
//                            intent.putExtra("tel",telefon);
                            Müşteri müşteri=new Müşteri(adsoyad,mail,telefon);
                            intent.putExtra("müşterinesnesi",müşteri);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}