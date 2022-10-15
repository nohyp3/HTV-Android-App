package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText firstNumber = findViewById(R.id.number1);
        EditText secondNumber = findViewById(R.id.number2);
        RadioGroup operators = findViewById(R.id.radioGroup);
        RadioButton add = findViewById(R.id.addition);
        RadioButton subtract = findViewById(R.id.subtraction);
        Button equals = findViewById(R.id.equals);
        TextView result = findViewById(R.id.result);

        //need event listeners step 8
        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int firstNum = Integer.parseInt(firstNumber.getText().toString());
                int secondNum = Integer.parseInt(secondNumber.getText().toString());

                int operationDecision = operators.getCheckedRadioButtonId();

                Integer answer = 0;

                if(operationDecision == R.id.addition){
                    answer = firstNum+secondNum;
                }
                else {
                    answer = secondNum - firstNum;
                }
                result.setText(answer.toString());
            }
        });
    }
}