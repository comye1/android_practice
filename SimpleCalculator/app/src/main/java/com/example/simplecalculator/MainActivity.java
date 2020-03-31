package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1Text, num2Text;
    Button addButton, subButton, mulButton, divButton;
    TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1Text = (EditText)findViewById(R.id.num1Text);
        num2Text = (EditText)findViewById(R.id.num2Text);
        addButton = (Button)findViewById(R.id.addButton);
        subButton = (Button)findViewById(R.id.substractButton);
        mulButton = (Button)findViewById(R.id.multiplyButton);
        divButton = (Button)findViewById(R.id.divideButton);
        resText = (TextView)findViewById(R.id.TextResult);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(num1Text.getText().toString());
                int num2 = Integer.parseInt(num2Text.getText().toString());

                int result = num1 + num2;
                resText.setText("계산 결과 : " + result);
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(num1Text.getText().toString());
                int num2 = Integer.parseInt(num2Text.getText().toString());

                int result = num1 - num2;
                resText.setText("계산 결과 : " + result);
            }
        });
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(num1Text.getText().toString());
                int num2 = Integer.parseInt(num2Text.getText().toString());

                int result = num1 * num2;
                resText.setText("계산 결과 : " + result);
            }
        });
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(num1Text.getText().toString());
                int num2 = Integer.parseInt(num2Text.getText().toString());

                int result = num1 / num2;
                resText.setText("계산 결과 : " + result);
            }
        });
    }
}
