package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_anapara, txt_yıllıkfaiz, txt_toplam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_anapara=findViewById(R.id.txt_anapara);

        txt_yıllıkfaiz=findViewById(R.id.txt_yıllıkfaiz);

        txt_toplam=findViewById(R.id.txt_toplam);

        txt_anapara.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!(TextUtils.isEmpty(txt_anapara.getText())||TextUtils.isEmpty(txt_yıllıkfaiz.getText()))) {
                    hesaplamaYap();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt_yıllıkfaiz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!(TextUtils.isEmpty(txt_anapara.getText())||TextUtils.isEmpty(txt_yıllıkfaiz.getText()))){
                    hesaplamaYap();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void hesaplamaYap(){

        double toplampara=Double.valueOf(txt_anapara.getText().toString())+Double.valueOf(txt_anapara.getText().toString())*Double.valueOf(txt_yıllıkfaiz.getText().toString())/100;
        txt_toplam.setText("Toplam:"+toplampara);
    }
}