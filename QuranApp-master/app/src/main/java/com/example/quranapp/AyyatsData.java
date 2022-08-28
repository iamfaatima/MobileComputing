package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AyyatsData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayyats_data);

        Intent intent = getIntent();
        int surahindex = intent.getIntExtra("surahindex",0);

        ListView listView = findViewById(R.id.ayyatsLST);
        QuranData quranData = new QuranData();
        int startingIndex = quranData.SSP[surahindex];
        int endingIndex = quranData.SSP[surahindex + 1];
        Quran quran = new Quran();
        ArrayList<String> ayyatList = new ArrayList<String>();
        for(int i=startingIndex-1; i<endingIndex-1; i++)
        {
            ayyatList.add(quran.QuranArabicText[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ayyatList);
        listView.setAdapter(arrayAdapter);
    }
}