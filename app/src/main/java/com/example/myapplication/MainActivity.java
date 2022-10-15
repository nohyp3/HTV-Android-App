package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main   );



    }
    static int treeNum = 0;
    public void changeTree (View view) {
        TextView treeCounter = findViewById(R.id.treeCounter);
        treeCounter.setText("Number of trees: " + treeNum++);

    }
    public void onBtnClick(View view) {
        TextView txtCameronTest = findViewById(R.id.txtCameronTest);
        EditText txtResponse = findViewById(R.id.txtResponse);
        txtCameronTest.setText("Hi you are" + txtResponse.getText().toString());

    }
}
