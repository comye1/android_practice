package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnabled, cbClickable, cbRotate;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        button = (Button)findViewById(R.id.button);
        cbEnabled = (CheckBox)findViewById(R.id.cbEnabled);
        cbClickable = (CheckBox)findViewById(R.id.cbClickable);
        cbRotate = (CheckBox)findViewById(R.id.cbRotate);

        cbEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    button.setEnabled(false);
                }else{
                    button.setEnabled(true);
                }
            }
        });

        cbClickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    button.setClickable(true);
                }else{
                    button.setClickable(false);
                }
            }
        });
    }
}
