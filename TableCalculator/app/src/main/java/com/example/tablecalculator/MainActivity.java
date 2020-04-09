package com.example.tablecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3,
            R.id.btnNum4, R.id.btnNum5, R.id.btnNum6, R.id.btnNum7,
            R.id.btnNum8, R.id.btnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText)findViewById(R.id.editNum1);
        edit2 = (EditText)findViewById(R.id.editNum2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        textResult = (TextView)findViewById(R.id.textResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) + Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) - Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) * Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) / Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);
            }
        });
    }
}
