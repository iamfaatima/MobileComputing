package com.example.quranapplistview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import com.example.quranapplistview.databinding.ActivityPartBinding; //can be cause of error
import com.example.quranapplistview.databinding.ActivityParahBinding;
import com.example.quranapplistview.databinding.ActivitySurahBinding;

public class Part extends AppCompatActivity {

    ActivityPartBinding binding;
    ListView Part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        int PartId = i.getIntExtra("PartId", 0);

        PartId = PartId + 1;

        Part = findViewById(R.id.Partlv);

        DatabaseAccess dbAccess = DatabaseAccess.getInstance(getApplicationContext());
        dbAccess.open();

        ArrayList<EnglishATModel> list = dbAccess.GetEngPart(PartId);

        ListAdapter20 listAdapter = new ListAdapter20(this, list);

        //ArrayAdapter<StudentModel> arrayAdapter = new ArrayAdapter<StudentModel>
        //(MainActivity.this, R.layout.list_item, R.id.NameMan, list);
        binding.Partlv.setAdapter(listAdapter);

        dbAccess.close();
    }
}