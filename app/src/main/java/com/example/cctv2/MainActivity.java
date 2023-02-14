package com.example.cctv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    TextView tvIni;

    String s1[], s2[], link[];
    int img[] = {R.drawable.tugu_welcome_gk, R.drawable.bunderan_siyono, R.drawable.alun_wono, R.drawable.bunderan_pln,
            R.drawable.simpang4rsud, R.drawable.jalanbaronmulo, R.drawable.simpanggading,R.drawable.manthousplayen, R.drawable.pantaibaron, R.drawable.pantaikukup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerView);
        tvIni = findViewById(R.id.tvDate);
        s1 = getResources().getStringArray(R.array.areaCctv);
        s2 = getResources().getStringArray(R.array.kapanewon);
        //link = getResources().getStringArray(R.array.linkVideo);

        cctvAdapter cctvadap = new cctvAdapter(this, s1,s2,img, link);
        recyclerview.setAdapter(cctvadap);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getToday();
    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String hari = (String) DateFormat.format("EEEE", date);
        String tanggal = (String) DateFormat.format("dd", date);
        String bulan = (String) DateFormat.format("MMMM", date);
        String tahun = (String) DateFormat.format("yyyy", date);
        String formatFix = hari + ", " + tanggal + " " + bulan + " " + tahun;
        tvIni.setText(formatFix);

    }
}