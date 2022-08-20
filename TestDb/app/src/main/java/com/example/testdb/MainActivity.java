package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    Switch isActive;
    RecyclerView studentRecyclerView;
    Button add, view;
    MyRecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(MainActivity.this);
        name = findViewById(R.id.editTextTextPersonName);
        age= findViewById(R.id.age);
        isActive=findViewById(R.id.IsActive);
        add=findViewById(R.id.Add);
        view = findViewById(R.id.ViewAll);

        studentRecyclerView = findViewById(R.id.StudentRecyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        studentRecyclerView.setLayoutManager(layoutManager);

        adapter= new MyRecyclerViewAdapter(dbHelper.getStudents());
        studentRecyclerView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            StudentModel student;
            @Override
            public void onClick(View view) {
                try {
                    student = new StudentModel(name.getText().toString(), Integer.parseInt(age.getText().toString()), isActive.isChecked());
                    DBHelper dbHelper = new DBHelper(MainActivity.this);
                    dbHelper.addStudent(student);
                    Toast.makeText(MainActivity.this,student.toString(),Toast.LENGTH_SHORT).show();
                }
                catch(Exception ex) {
                    Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter= new MyRecyclerViewAdapter(dbHelper.getStudents());
                studentRecyclerView.setAdapter(adapter);
            }
        });

        studentRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
}