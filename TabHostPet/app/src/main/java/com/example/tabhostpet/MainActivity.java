package com.example.tabhostpet;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.tabhostpet.R;

@SuppressWarnings("deprecation")

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        tabHost.setup();

        TabHost.TabSpec tsDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tsDog.setContent(R.id.dog);
        tabHost.addTab(tsDog);

        TabHost.TabSpec tsCat= tabHost.newTabSpec("CAT").setIndicator("고양이");
        tsCat.setContent(R.id.cat);
        tabHost.addTab(tsCat);

        TabHost.TabSpec tsRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tsRabbit.setContent(R.id.rabbit);
        tabHost.addTab(tsRabbit);

        TabHost.TabSpec tsHorse = tabHost.newTabSpec("HORSE").setIndicator("말");
        tsHorse.setContent(R.id.horse);
        tabHost.addTab(tsHorse);

        tabHost.setCurrentTab(0);

    }
}