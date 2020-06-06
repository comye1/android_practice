package com.example.firebasedbtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private EditText editText;
    private Button btn_Logout, btn_Revoke, btn_Submit;
    private LinearLayout inner;
    private ScrollView scroll;
    private DatabaseReference mDatabase;// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();



        Toast.makeText(getApplicationContext(), user.getEmail() + "로 로그인 되었습니다.", Toast.LENGTH_LONG).show();

        mDatabase = FirebaseDatabase.getInstance().getReference();


        inner = findViewById(R.id.inner);
        scroll = findViewById(R.id.scrollView);

        DisplayData();

        editText = findViewById(R.id.editText);

        btn_Submit = findViewById(R.id.btn_Submit);

        btn_Logout = findViewById(R.id.btn_LogOut);
        btn_Revoke = findViewById(R.id.btn_Revoke);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String text = editText.getText().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
                Date time = new Date();
                final String date = sdf.format(time);
                mDatabase.child("User").child(mAuth.getUid()).child(date).setValue(text);
//                //User 밑 Uid 밑 text로 넣음

                editText.setText(null);
            }
        });




        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finishAffinity();
            }
        });

        btn_Revoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mAuth.getCurrentUser().delete();
                user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getApplicationContext(), "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                }
                            });
                }
//[출처] [안드로이드 스튜디오] Firebase Authentication을 이용한 간단한 회원가입및 로그인 구현하기|작성자 코스모스

//                finishAffinity();
            }
        });


    }

    void ScrollDown(){
        //스크롤뷰의 스크롤을 맨 아래로 내려줌
        scroll.post(new Runnable() {
            @Override
            public void run() {
                scroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    void Display(String text){

        TextView message = new TextView(getApplicationContext());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,10,10,10);
        message.setLayoutParams(layoutParams);

        message.setBackgroundColor(Color.rgb(255,235,155));
        message.setPadding(10,10,10,10);
        message.setText(text);
        message.setTextSize(20);
        //스크롤뷰 내 리니어레이아웃에 텍스트뷰 추가
        inner.addView(message);

        //스크롤뷰 제일 밑으로 내리기
        ScrollDown();
    }

    void DisplayData(){
        //데이터 변경, 추가 시 바로 view 추가
        mDatabase.child("User").child(mAuth.getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Display(dataSnapshot.getValue().toString());//자식(child)의 값(value)을 출력
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Display("hi~");//dataSnapshot.child("text").getValue().toString()
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

