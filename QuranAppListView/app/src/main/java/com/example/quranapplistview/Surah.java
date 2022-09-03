package com.example.quranapplistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Surah extends AppCompatActivity {
    ListView surahlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        Intent intent=getIntent();
        surahlist=findViewById(R.id.ayaat_list);
        DBHelper helper=new DBHelper(Surah.this);
        List<Ayaat_Model> ayaat_modelList;
        if(intent.getStringExtra("type").equals("Surah")) {
            ayaat_modelList=helper.readAyah_surah(intent.getIntExtra("position", 0)+1);
        }
        else
        {
            ayaat_modelList=helper.readAyah_para(intent.getIntExtra("position", 0)+1);
        }
        CustomAdapter adapter=new CustomAdapter(Surah.this, ayaat_modelList);
        surahlist.setAdapter(adapter);
    }
}