package com.example.sdimageviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button button_Prev, button_Next;
    myPictureView myPictureView;
    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(
                this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        button_Prev = (Button)findViewById(R.id.button_Prev);
        button_Next = (Button)findViewById(R.id.button_Next);
        myPictureView = (myPictureView) findViewById(R.id.myPictureView);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures/Screenshots").listFiles();
        imageFname = imageFiles[0].toString();
        myPictureView.imagePath = imageFname;

        button_Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum <= 0){
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPictureView.imagePath = imageFname;
                    myPictureView.invalidate();
                }
            }
        });

        button_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curNum >= imageFiles.length-1){
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    curNum++;
                }
            }
        });
    }
}
