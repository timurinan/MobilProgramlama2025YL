package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_sayı;
    Button btn_azalt, btn_arttır;

    int sayı=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_sayı=findViewById(R.id.txt_sayı);

        btn_azalt=findViewById(R.id.btn_azalt);
        btn_arttır=findViewById(R.id.btn_arttır);

        btn_arttır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayı++;
                txt_sayı.setText(sayı+"");
            }
        });

       // btn_azalt.setOnClickListener(v -> azalt());
    }

    public void azalt(View v){
        sayı--;
        txt_sayı.setText(sayı+"");
    }


}