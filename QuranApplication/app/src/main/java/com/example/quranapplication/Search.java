package com.example.quranapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search extends AppCompatActivity {

    EditText searchText;
    ListView surahNameView;
    ArrayList<SurahModel> surahModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        DBHelper dbHelper = new DBHelper(Search.this);
        searchText = findViewById(R.id.searchText);
        surahNameView = findViewById(R.id.surahNameView);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                surahModelArrayList = dbHelper.readSurah(searchText.getText().toString());
                custom_surahAdapter QuranAdapter = new custom_surahAdapter(Search.this,surahModelArrayList);
                surahNameView.setAdapter(QuranAdapter);
                surahNameView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(Search.this,Surah.class);
                        intent.putExtra("SurahName",surahModelArrayList.get(i).getSurahNameE());
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }
}