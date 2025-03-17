package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_final_notu,txt_vize_notu,txt_lab_notu,txt_vize_ağırlık,txt_lab_ağırlık,txt_final_ağırlık,txt_ortalama;
    Button btn_hesapla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_vize_notu=findViewById(R.id.txt_vize_notu);
        txt_vize_ağırlık=findViewById(R.id.txt_vize_ağırlık);

        txt_lab_notu=findViewById(R.id.txt_laboratuvar_notu);
        txt_lab_ağırlık=findViewById(R.id.txt_laboratuvar_ağırlık);

        txt_final_notu=findViewById(R.id.txt_final_notu);
        txt_final_ağırlık=findViewById(R.id.txt_final_ağırlık);

        txt_ortalama=findViewById(R.id.txt_sonuç);
        btn_hesapla=findViewById(R.id.btn_hesapla);

        btn_hesapla.setOnClickListener(v -> hesaplamaYap());
    }
    private void hesaplamaYap(){

        if(TextUtils.isEmpty(txt_vize_notu.getText())||TextUtils.isEmpty(txt_vize_ağırlık.getText())||
                TextUtils.isEmpty(txt_lab_notu.getText())||TextUtils.isEmpty(txt_lab_ağırlık.getText())||
                TextUtils.isEmpty(txt_final_notu.getText())||TextUtils.isEmpty(txt_lab_ağırlık.getText())){
            Toast.makeText(this, "Hesaplama yapmak için alanların hepsinin dolu olması gerekir", Toast.LENGTH_LONG).show();
        }else{
            double vizenotu=Double.valueOf(txt_vize_notu.getText().toString());
            double labnotu=Double.valueOf(txt_lab_notu.getText().toString());
            double finalnotu=Double.valueOf(txt_final_notu.getText().toString());
            if(vizenotu>=0&&vizenotu<=100&& labnotu>=0&&labnotu<=100 &&finalnotu>=0&&finalnotu<=100){
                double vizeağırlık=Double.valueOf(txt_vize_ağırlık.getText().toString());
                double labağırlık=Double.valueOf(txt_lab_ağırlık.getText().toString());
                double finalağırlık=Double.valueOf(txt_final_ağırlık.getText().toString());
                if(vizeağırlık+labağırlık+finalağırlık!=100){
                    Toast.makeText(this, "Ağırlıklar toplamı 100 den farklı olamaz", Toast.LENGTH_LONG).show();
                }else{
                    double ortalama=(vizenotu*vizeağırlık/100)+(labnotu*labağırlık/100)+(finalnotu*finalağırlık/100);
                    txt_ortalama.setText(ortalama+"");
                }
            }else{
                Toast.makeText(this, "Notlar 0 ile 100 arasında olmalıdır", Toast.LENGTH_SHORT).show();
            }
        }
    }
}