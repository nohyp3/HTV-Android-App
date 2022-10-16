package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {
    VideoView theVideo;
    public void camera(View view){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        theVideo = (VideoView)findViewById(R.id.videoView);
        Uri uri = Uri.parse("https://media.discordapp.net/attachments/1030245283893878804/1031040678303629412/IMG_2933.MOV.mp4");
        // set the uri for the video view
        theVideo.setVideoURI(uri);
        // start a video
        theVideo.start();

    }

}