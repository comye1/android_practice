package com.example.chapter05_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        );

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(params);


        LinearLayout.LayoutParams paramsH = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1
        );
        LinearLayout layoutH = new LinearLayout(this);
        layoutH.setOrientation(LinearLayout.HORIZONTAL);
        layoutH.setLayoutParams(paramsH);


        LinearLayout.LayoutParams paramsP = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1
        );
        LinearLayout layoutP = new LinearLayout(this);
        layoutP.setBackgroundColor(Color.parseColor("purple"));
        layoutP.setLayoutParams(paramsP);

        LinearLayout.LayoutParams paramsR = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1
        );
        LinearLayout layoutR = new LinearLayout(this);
        layoutR.setBackgroundColor(Color.rgb(255,0,0));
        layoutR.setLayoutParams(paramsR);

        LinearLayout.LayoutParams paramsV = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1
        );
        LinearLayout layoutV = new LinearLayout(this);
        layoutV.setOrientation(LinearLayout.VERTICAL);
        layoutV.setLayoutParams(paramsV);

        LinearLayout.LayoutParams paramsY = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1
        );
        LinearLayout layoutY = new LinearLayout(this);
        layoutY.setBackgroundColor(Color.rgb(255,255,0));
        layoutY.setLayoutParams(paramsY);

        LinearLayout.LayoutParams paramsB = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1
        );
        LinearLayout layoutB = new LinearLayout(this);
        layoutB.setBackgroundColor(Color.rgb(0,0,0));
        layoutB.setLayoutParams(paramsB);

        layoutV.addView(layoutY);
        layoutV.addView(layoutB);

        layoutH.addView(layoutR);
        layoutH.addView(layoutV);

        baseLayout.addView(layoutH);
        baseLayout.addView(layoutP);


        setTitle("연습문제 5-7");
        setContentView(baseLayout);


    }
}
