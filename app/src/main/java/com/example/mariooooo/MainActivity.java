package com.example.mariooooo;

import static android.view.WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button StartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartButton = findViewById(R.id.StartButton);
        StartButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.StartButton){
            Intent intent = new Intent(getApplication(),GameActivity.class);
            startActivity(intent);
        }
    }
}