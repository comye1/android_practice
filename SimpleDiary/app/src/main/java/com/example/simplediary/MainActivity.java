package com.example.simplediary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
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

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = year+"_"+(monthOfYear+1)+"_"+dayOfMonth+".txt";
                String str = readDiary(fileName);
                editText_Diary.setText(str);
                button_Write.setEnabled(true);
            }
        });


    }

    String readDiary(String fileName) {
        String diary = null;
        FileInputStream input;
        try{
            input = openFileInput(fileName);
            byte[] text = new byte[500];
            input.read(text);
            input.close();
        }catch (IOException e){
            editText_Diary.setHint("일기 없음");
            button_Write.setText("새로 저장");
        }

        return diary;
    }
}
