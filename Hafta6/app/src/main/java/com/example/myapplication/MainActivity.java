package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_liste);
        floatingActionButton=findViewById(R.id.fab_buton);

        ArrayList<Müşteri> müşteriler=new ArrayList<Müşteri>();

        müşteriler.add(new Müşteri("Timur İnan","timurinan@hotmail.com","116262737"));
        müşteriler.add(new Müşteri("Ahmet İnan","ahmetinan@hotmail.com","45498785445"));
        müşteriler.add(new Müşteri("Hande İnan","handeinan@hotmail.com","0000000000000"));

        BenimAdapter ba=new BenimAdapter(müşteriler,MainActivity.this);
        recyclerView.setLongClickable(true);
        recyclerView.setAdapter(ba);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ekle_intent=new Intent(MainActivity.this, EkleActivity.class);
                startActivity(ekle_intent);
            }
        });


    }
}