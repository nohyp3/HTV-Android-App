package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//this is camera
public class MainActivity3 extends AppCompatActivity {
    private static final int picId = 1;
    private static final int CAMERA_PERMISSION_CODE = 100;

    ImageView click_image_id;
    Button camera;
    private Button cameraPerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
        camera = findViewById(R.id.camera);
        click_image_id = findViewById(R.id.proof);
        cameraPerm = findViewById(R.id.cameraPer);
        cameraPerm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE);
            }
        });
        // Camera_open button is for open the camera and add the setOnClickListener in this button
        camera.setOnClickListener(v -> {
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(camera_intent, picId);
        });
    }
    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity3.this, permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity3.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(MainActivity3.this, "Permission already granted", Toast.LENGTH_SHORT).show();
            cameraPerm.setVisibility(View.GONE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity3.this, "Camera Permission Granted", Toast.LENGTH_SHORT) .show();
                cameraPerm.setVisibility(View.INVISIBLE);
            }
            else {
                Toast.makeText(MainActivity3.this, "Camera Permission Denied", Toast.LENGTH_SHORT) .show();
            }
        }
    }


    static int treeNum = 0;
    public void changeTree (View view) {
        TextView treeCounter = findViewById(R.id.treeCounter);
        treeCounter.setText("Number of trees: " + treeNum++);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == picId) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }
    }
}