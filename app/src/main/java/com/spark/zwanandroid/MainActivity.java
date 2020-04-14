package com.spark.zwanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.spark.zwanandroid.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {


    TextView mBtn;
    TextView mBtnCrash;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        mBtnCrash = findViewById(R.id.btn_crash);
        mBtnCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.split(" ");
            }
        });
    }
}
