package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;



import android.os.Bundle;
//Pushup activity class, corresponds to activity_main2.xml
public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    static int pushupCountNum = 0;
    public void addPushup(View view){
        TextView setPushupCount = findViewById(R.id.pushupCounter);
        TextView setEncourageText = findViewById(R.id.encourageText);
        pushupCountNum ++;
        setPushupCount.setText("Pushup Count: " + pushupCountNum);
        if (pushupCountNum == 5){
            setEncourageText.setText("You can do more than that!");
        }
        if (pushupCountNum == 10){
            setEncourageText.setText("Strength does not come from physical capacity.");
        }
        if (pushupCountNum == 15) {
            setEncourageText.setText("The body achieves what the mind believes.");
        }
        if (pushupCountNum == 20) {
            setEncourageText.setText("The last three or four reps is what makes the muscle grow.");
        }
        if (pushupCountNum == 25) {
            setEncourageText.setText("What seems impossible today will one day become your warm-up.");
        }
        if (pushupCountNum == 30) {
            setEncourageText.setText("There are two types of pain in this world: pain that hurts you, and pain that changes you.");
        }
    }
}