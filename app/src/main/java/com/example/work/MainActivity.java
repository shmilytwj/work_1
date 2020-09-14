package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.Login);
        button.setOnClickListener(new MyClickListener());
        Button bt=(Button)findViewById(R.id.Confirm);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null, false);
                builder.setTitle("提示框");
                builder.setView(viewDialog);
                builder.create().show();
            }
        });
    }


    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(final View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.customdialog, null, false);
            builder.setTitle("登录界面");
            builder.setView(viewDialog);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    EditText UserId=viewDialog.findViewById(R.id.UserId);
                    EditText Password=viewDialog.findViewById(R.id.Password);
                    if( UserId.getText().toString().equals("abc") && Password.getText().toString().equals("123"))
                        Toast.makeText(MainActivity.this,"登陆成功 ",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                }
            });
            builder.create().show();

        }
    }
}