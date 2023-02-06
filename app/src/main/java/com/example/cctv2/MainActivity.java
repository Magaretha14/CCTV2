package com.example.cctv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    String s1[], s2[];
    int img[] = {R.drawable.tugu, R.drawable.bunderan_siyono, R.drawable.alun_wono};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.kapanewon);

        cctvAdapter cctvadap = new cctvAdapter(this, s1,s2,img);
        recyclerview.setAdapter(cctvadap);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}