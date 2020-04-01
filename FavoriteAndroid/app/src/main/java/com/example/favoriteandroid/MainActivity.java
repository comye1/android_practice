package com.example.favoriteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Switch swStart;
    TextView invisibleText;
    RadioGroup radioGroup;
    RadioButton oreo, pie, q;
    ImageView imageView;
    Button btnFinish, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진 보기");

        swStart = (Switch)findViewById(R.id.swStart);
        invisibleText = (TextView)findViewById(R.id.invisibleText);
        radioGroup = (RadioGroup)findViewById(R.id.rGroup);
        oreo = (RadioButton)findViewById(R.id.rbOreo);
        pie = (RadioButton)findViewById(R.id.rbPie);
        q = (RadioButton)findViewById(R.id.rbQ);
        imageView = (ImageView)findViewById(R.id.imageView);
        btnFinish = (Button)findViewById(R.id.btnFinish);
        btnReset = (Button)findViewById(R.id.btnReset);

        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    invisibleText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);

                }else{
                    invisibleText.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    oreo.setChecked(false);
                    pie.setChecked(false);
                    q.setChecked(false);
                }
            }
        });
    }
}
