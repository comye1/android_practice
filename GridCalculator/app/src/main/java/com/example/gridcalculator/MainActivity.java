package com.example.gridcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gridcalculator.R;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3,
            R.id.btnNum4, R.id.btnNum5, R.id.btnNum6, R.id.btnNum7,
            R.id.btnNum8, R.id.btnNum9};
    int i;
    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.editNum1);
        edit2 = (EditText) findViewById(R.id.editNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        textResult = (TextView) findViewById(R.id.textResult);

        for (i = 0; i < numButtons.length; i++) {
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i=0; i<numButtons.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()){
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }else if(edit2.isFocused()){
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 클릭하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) + Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) - Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) * Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                int result = Integer.parseInt(num1) / Integer.parseInt(num2);

                textResult.setText("계산 결과 : " + result);
            }
        });
    }
}
