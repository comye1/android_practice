package com.example.simplediary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText_Diary;
    Button button_Write;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일기장");

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        editText_Diary = (EditText) findViewById(R.id.editText_Diary);
        button_Write = (Button) findViewById(R.id.button_Write);

    }
}
