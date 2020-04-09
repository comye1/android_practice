package com.example.layout_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
//        );
//
//        LinearLayout baseLayout = new LinearLayout(this);
//        baseLayout.setOrientation(LinearLayout.VERTICAL);
//        setContentView(baseLayout, params);
//
//        final EditText editText = new EditText(this);
//        editText.setHint("입력하세요");
//        baseLayout.addView(editText);
//
//        Button button = new Button(this);
//        button.setBackgroundColor(Color.rgb(200,255,0));
//        button.setText("버튼입니다");
//        baseLayout.addView(button);
//
//        final TextView textView = new TextView(this);
//        textView.setTextColor(Color.MAGENTA);
//        textView.setTextSize(32);
//        baseLayout.addView(textView);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str = editText.getText().toString();
//                textView.setText(str);
//            }
//        });
    }
}
