package com.example.cctv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

public class ViewCCTV extends AppCompatActivity {
    PlayerView playerView;
    ExoPlayer exoPlayer;
    TextView area, kapanewon;

    String data1, data2;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cctv);

        area = findViewById(R.id.textView);
        kapanewon = findViewById(R.id.textView2);
        getData();
        setData();

        String videoUrl[];
        videoUrl = getResources().getStringArray(R.array.linkVideo);

        //String videoUrl = "http://103.141.234.194:8080/live/bunderan-siyono.flv";



        exoPlayer = new ExoPlayer.Builder(this).build();
        playerView = findViewById(R.id.exoplayer);
        playerView.setPlayer(exoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(String.valueOf(videoUrl));
        exoPlayer.addMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }

    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        area.setText(data1);
        kapanewon.setText(data2);
    }
}