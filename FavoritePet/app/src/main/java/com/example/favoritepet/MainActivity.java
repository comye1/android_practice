package com.example.favoritepet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    CheckBox checkStart;
    RadioGroup radioGroup;
    RadioButton dog, cat, rabbit;
    Button selectButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStart = (CheckBox)findViewById(R.id.checkStart);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        dog = (RadioButton)findViewById(R.id.radioDog);
        cat = (RadioButton)findViewById(R.id.radioCat);
        rabbit = (RadioButton)findViewById(R.id.radioRabbit);
        selectButton = (Button)findViewById(R.id.buttonSelected);
        imageView = (ImageView)findViewById(R.id.imageView);
 
    }
}
