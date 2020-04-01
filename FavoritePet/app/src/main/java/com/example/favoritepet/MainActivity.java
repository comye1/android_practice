package com.example.favoritepet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox checkStart;
    TextView invisibleText;
    RadioGroup radioGroup;
    RadioButton dog, cat, rabbit;
    Button selectButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStart = (CheckBox)findViewById(R.id.checkStart);
        invisibleText = (TextView)findViewById(R.id.invisibleText);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        dog = (RadioButton)findViewById(R.id.radioDog);
        cat = (RadioButton)findViewById(R.id.radioCat);
        rabbit = (RadioButton)findViewById(R.id.radioRabbit);
        selectButton = (Button)findViewById(R.id.buttonSelected);
        imageView = (ImageView)findViewById(R.id.imageView);

        checkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkStart.isChecked()) {
                    invisibleText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    selectButton.setVisibility(View.VISIBLE);
                }
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioDog:
                        imageView.setImageResource(R.drawable.puppy);
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioCat:
                        imageView.setImageResource(R.drawable.cat);
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioRabbit:
                        imageView.setImageResource(R.drawable.rabbit);
                        imageView.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}
