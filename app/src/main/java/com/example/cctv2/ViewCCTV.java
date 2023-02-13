package com.example.cctv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaDataSource;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ViewCCTV extends AppCompatActivity {
    PlayerView playerView;
    ExoPlayer exoPlayer;
    TextView area, kapanewon;

    String data1;
    String data2;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cctv);

        area = findViewById(R.id.textView);
        kapanewon = findViewById(R.id.textView2);
        playerView = findViewById(R.id.exoplayercctv);
        getData();
        setData();

        //String[] videoUrl = getResources().getStringArray(R.array.linkVideo);

        // Create a list of media items
        List<MediaItem> mediaItems = new ArrayList<>();
        mediaItems.add(new MediaItem.Builder().setUri("http://103.141.234.194:8080/live/tugu-selamat-datang-patuk.flv").build());
        mediaItems.add(new MediaItem.Builder().setUri("http://103.141.234.194:8080/live/bunderan-siyono.flv").build());
        mediaItems.add(new MediaItem.Builder().setUri("http://103.141.234.194:8080/live/alun-alun-wonosari.flv").build());

// Create an instance of ExoPlayer
        ExoPlayer exoPlayer = new ExoPlayer.Builder(context).build();

// Create a PlayerControl instance to control the player
        //PlayerControl playerControl = new PlayerControl(exoPlayer);

        PlayerControlView playerControlView = new PlayerControlView(context);

// Add the media items to the player
        playerView.setPlayer((Player) playerControlView);
        exoPlayer.addMediaItems(mediaItems);

// Start playing the first media item
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);


        /*exoPlayer = new ExoPlayer.Builder(this).build();
        playerView.setPlayer(exoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(videoUrl);
        exoPlayer.addMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);*/

    }

    private void getData(){
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            //videoUrl = getIntent().getStringExtra("videoUrl");

        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        area.setText(data1);
        kapanewon.setText(data2);
    }
}