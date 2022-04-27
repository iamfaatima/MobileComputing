package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button incBtn = findViewById(R.id.incrementBtn);
        Button decBtn = findViewById(R.id.decrementBtn);
        TextView counterText = findViewById(R.id.counterText);

        incBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        counterText.setText(String.valueOf(Integer.parseInt(counterText.getText().toString())+1));
                    }
                }
        );

        decBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        counterText.setText(String.valueOf(Integer.parseInt(counterText.getText().toString())-1));
                    }
                }
        );
    }
}