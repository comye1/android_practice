package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView_Name, textView_Email, textView_Toast;
    Button button_Input;
    EditText editText_Name, editText_Email;
    View view_Dialog, view_Toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        textView_Name = (TextView)findViewById(R.id.textview_Name);
        textView_Email = (TextView)findViewById(R.id.textView_Email);
        button_Input = (Button)findViewById(R.id.button_Input);

        button_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_Dialog = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setView(view_Dialog);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editText_Name = (EditText)view_Dialog.findViewById(R.id.editText_Name);
                        editText_Email = (EditText)view_Dialog.findViewById(R.id.editText_Email);

                        textView_Name.setText(editText_Name.getText());
                        textView_Email.setText(editText_Email.getText());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        view_Toast = (View)View.inflate(MainActivity.this, R.layout.toast1, null);
                        textView_Toast = (TextView)view_Toast.findViewById(R.id.textView_Toast);
                        textView_Toast.setText("취소되었습니다.");
                        toast.setView(view_Toast);
                        toast.show();
                    }
                });
                dlg.show();
            }


        });
    }
}
