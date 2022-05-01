package com.example.guesstheletter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView guess, answer;
    Button root, grass, sky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root=(Button)findViewById(R.id.b_root);
        grass=(Button)findViewById(R.id.b_grass);
        sky=(Button)findViewById(R.id.b_sky);
        guess=(TextView)findViewById(R.id.txt_guess);
        answer=(TextView)findViewById(R.id.txt_ans);

        Random random = new Random();
        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
        guess.setText(randomizedCharacter + "");

        char[] grass_array = {'a','c','e','i','m','n','o','r','s','u','v','w','x','z'}; //14
        char[] sky_array = {'b','d','f','h','k','l','t'}; //7
        char[] root_array = {'g','j','p','q','y'};//5

        grass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < grass_array.length; i++){
                    int compare = Character.compare(randomizedCharacter, grass_array[i]);
                    if(compare > 0){
                        answer.setText("Correct" + "");
                        break;
                    }
                    else{
                        answer.setText("Wrong"+ "");
                        break;
                    }

                    }
                }

            }
        );

        sky.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         for (int i = 0; i < sky_array.length; i++){
                                             int compare = Character.compare(randomizedCharacter, sky_array[i]);
                                             if(compare > 0){
                                                 answer.setText("Correct" + "");
                                                 break;
                                             }
                                             else{
                                                 answer.setText("Wrong" + "");
                                                 break;
                                             }

                                         }
                                     }

                                 }
        );

        root.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         for (int i = 0; i < root_array.length; i++){
                                             int compare = Character.compare(randomizedCharacter, root_array[i]);
                                             if(compare > 0){
                                                 answer.setText("Correct" + "");
                                                 break;
                                             }
                                             else{
                                                 answer.setText("Wrong" + "");
                                                 break;
                                             }

                                         }
                                     }

                                 }
        );
    }
}