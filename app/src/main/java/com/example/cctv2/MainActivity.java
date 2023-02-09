package com.example.cctv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    String s1[], s2[], link[];
    int img[] = {R.drawable.tugu_welcome_gk, R.drawable.bunderan_siyono, R.drawable.alun_wono, R.drawable.bunderan_pln,
            R.drawable.simpang4rsud, R.drawable.jalanbaronmulo, R.drawable.simpang4trowono, R.drawable.pantaibaron, R.drawable.pantaikukup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.areaCctv);
        s2 = getResources().getStringArray(R.array.kapanewon);
        link = getResources().getStringArray(R.array.linkVideo);

        cctvAdapter cctvadap = new cctvAdapter(this, s1,s2,img, link);
        recyclerview.setAdapter(cctvadap);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}