package com.example.intents_and_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Uri webpage = Uri.parse("https://github.com/iamfaatima/MobileComputing");
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(intent);

            }//end onclick
        });

    }

    public void learn(View view) {
        Intent intent = new Intent(MainActivity.this, Learn.class);
        startActivity(intent);
    }

    public void Test(View view) {
        Intent intent = new Intent(MainActivity.this, Test.class);
        startActivity(intent);
    }
    }
