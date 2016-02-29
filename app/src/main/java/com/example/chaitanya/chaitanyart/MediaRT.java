package com.example.chaitanya.chaitanyart;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.VideoView;
import android.view.View;
import android.net.Uri;
import android.widget.MediaController;

public class MediaRT extends AppCompatActivity {

    VideoView mVideoView;
    Button BTN_Play, BTN_Pause, BTN_Stop;
    MediaPlayer mediaPlayer;
    //private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_media);
        mVideoView = (VideoView) findViewById(R.id.videoView);

        BTN_Play = (Button) findViewById(R.id.btn_play);
        BTN_Pause = (Button) findViewById(R.id.btn_pause);
        BTN_Stop = (Button) findViewById(R.id.btn_stop);

        BTN_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.spooky);
                mediaPlayer.start();
                BTN_Pause.setVisibility(View.VISIBLE);
                BTN_Stop.setVisibility(View.VISIBLE);
            }
        });

        BTN_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        BTN_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                BTN_Pause.setVisibility(View.INVISIBLE);
                BTN_Stop.setVisibility(View.INVISIBLE);
            }
        });
    }


    public void playVideo(View view){
        String uriPath = "android.resource://" + getPackageName() + "/" + R.raw.sample;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
        mVideoView.requestFocus();
    }
}
