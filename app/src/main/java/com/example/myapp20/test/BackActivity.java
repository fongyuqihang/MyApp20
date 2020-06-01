package com.example.myapp20.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp20.R;

public class BackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Toast.makeText(BackActivity.this, "后退", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
