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

    String data1, data2, videoUrl;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cctv);

        area = findViewById(R.id.textView);
        kapanewon = findViewById(R.id.textView2);
        getData();
        setData();

        if (area.equals("Tugu Selamat Datang")){
            videoUrl = "http://103.141.234.194:8080/live/tugu-selamat-datang-patuk.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Bunderan Siyono")){
            videoUrl = "http://103.141.234.194:8080/live/bunderan-siyono.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Alun-Alun Wonosari")){
            videoUrl = "http://103.141.234.194:8080/live/alun-alun-wonosari.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Bunderan PLN")){
            videoUrl = "http://103.141.234.194:8080/live/bunderan-pln.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Simpang 4 RSUD")){
            videoUrl = "http://103.141.234.194:8080/live/simpang-4-rsud.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Ngingrong Mulo")){
            videoUrl = "http://103.141.234.194:8080/live/ngingrong-mulo.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Simpang 4 Trowono")){
           videoUrl = "http://103.141.234.194:8080/live/simpang-4-trowono.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Pantai Baron")){
            videoUrl = "http://103.141.234.194:8080/live/pantai-baron.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }
        else if (area.equals("Pantai Kukup")){
            videoUrl = "http://103.141.234.194:8080/live/pantai-kukup.flv";

            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView = findViewById(R.id.exoplayercctv);
            playerView.setPlayer(exoPlayer);
            MediaItem mediaItem = MediaItem.fromUri(videoUrl);
            exoPlayer.addMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(true);
        }

        //String videoUrl[];
        //videoUrl = getResources().getStringArray(R.array.linkVideo);

        //String videoUrl = "http://103.141.234.194:8080/live/bunderan-siyono.flv";

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