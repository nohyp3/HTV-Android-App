package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;
//this is running
public class MainActivity2 extends AppCompatActivity {
    VideoView theVideo;
    TextView scoreCount;
    private Accelerometer accelerometer;
    float score = 1; //this is the score for the runner

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

        //accl
        scoreCount = findViewById(R.id.score);
        accelerometer = new Accelerometer(this);
        accelerometer.setListener(new Accelerometer.Listener() {
            //on translation method of accelerometer
            @Override
            public void onTranslation(float tx, float ty, float ts) {
                // set the color red if the device moves in positive x axis
                if (tx > 1.0f) {
                    score+=tx;
                    scoreCount.setText(Float.toString(score));
                }
                // set the color blue if the device moves in negative x axis
                else if (tx < -1.0f) {
                    score+= Math.abs(tx);
                    scoreCount.setText(Float.toString(score));
                }
            }
        });
    }

}