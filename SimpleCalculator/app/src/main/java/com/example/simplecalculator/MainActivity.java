package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1Text, num2Text;
    Button addButton, subButton, mulButton, divButton, remButton;
    TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단 계산기");

        num1Text = (EditText)findViewById(R.id.num1Text);
        num2Text = (EditText)findViewById(R.id.num2Text);
        addButton = (Button)findViewById(R.id.addButton);
        subButton = (Button)findViewById(R.id.substractButton);
        mulButton = (Button)findViewById(R.id.multiplyButton);
        divButton = (Button)findViewById(R.id.divideButton);
        remButton = (Button)findViewById(R.id.remainderButton);
        resText = (TextView)findViewById(R.id.TextResult);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = num1Text.getText().toString().trim();
                String num2 = num2Text.getText().toString().trim();

                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    resText.setText("계산 결과 : " + result);
                }
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = num1Text.getText().toString().trim();
                String num2 = num2Text.getText().toString().trim();

                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    double result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    resText.setText("계산 결과 : " + result);
                }
            }
        });
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = num1Text.getText().toString().trim();
                String num2 = num2Text.getText().toString().trim();

                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    double result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    resText.setText("계산 결과 : " + result);
                }
            }
        });

        divButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String num1 = num1Text.getText().toString().trim();
                String num2 = num2Text.getText().toString().trim();

                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else if(num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    return false;
                }else{
                    double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    resText.setText("계산 결과 : " + result);
                }

                return false;
            }
        });

        remButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String num1 = num1Text.getText().toString().trim();
                String num2 = num2Text.getText().toString().trim();

                if(num1.equals("")||num2.equals("")){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else if(num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                    return false;
                }else{
                    double result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    resText.setText("계산 결과 : " + result);
                }

                return false;
            }
        });
    }
}
