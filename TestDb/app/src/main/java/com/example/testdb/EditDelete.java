package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class EditDelete extends AppCompatActivity {
    EditText name,age;
    Switch isActive;
    DBHelper dbHelper;
    Button update;
    StudentModel student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        student = dbHelper.getStudent(intent.getIntExtra("id",0));

        name = findViewById(R.id.editName);
        name.setText(student.getName());
        // editAge
        age=findViewById(R.id.editAge);
        age.setText(Integer.toString(student.getAge()));


        isActive = findViewById(R.id.editActive);
        isActive.setChecked(student.isActive());

        update = findViewById(R.id.Update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateStudent(new StudentModel(name.getText().toString(),Integer.parseInt(age.getText().toString()),isActive.isChecked(),student.getId()));
                finish();
            }
        });

    }
}