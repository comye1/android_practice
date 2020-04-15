package com.example.autoflipping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_start, button_stop;
        final ViewFlipper viewFlipper;

        button_start = (Button)findViewById(R.id.button_start);
        button_stop = (Button)findViewById(R.id.button_stop);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(1000);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.startFlipping();
            }
        });

        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });
    }
}
