package com.example.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button button;
        button = findViewById(R.id.btn_4);

        VideoView videoView = (VideoView)findViewById(R.id.videoView2);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vid);
        videoView.setVideoURI(uri);

        videoView.start();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(intent);

            }//end onclick
        });
    }
}