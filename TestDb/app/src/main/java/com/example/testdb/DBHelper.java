package com.example.testdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String STUDENT_NAME = "StudentName";
    public static final String STUDENT_AGE = "StudentAge";
    public static final String STUDENT_ACTIVE = "IsStudentActive";
    public static final String STUDENT_ID = "StudentID";
    public static final String STUDENT_TABLE = "StudentTable";

    public DBHelper(@Nullable Context context) {
        super(context, "Student.db", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query =
                "CREATE TABLE " + STUDENT_TABLE +
                        "( " + STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT," + STUDENT_NAME + " Text," +
                        STUDENT_AGE + " Integer, " + STUDENT_ACTIVE + " BOOL)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(sqLiteDatabase);
    }

    void addStudent(StudentModel student) {
        ContentValues cv = new ContentValues();

        cv.put(STUDENT_NAME, student.getName().toString());
        cv.put(STUDENT_AGE, Integer.toString(student.getAge()));
        cv.put(STUDENT_ACTIVE, student.isActive());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(STUDENT_TABLE, null, cv);
        db.close();

    }

    ArrayList<StudentModel> getStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        ArrayList<StudentModel> students = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                students.add(new StudentModel(cursor.getString(1), cursor.getInt(2), cursor.getInt(3) == 0 ? false : true,cursor.getInt(0)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return students;
    }
    StudentModel getStudent(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE+ " WHERE "+STUDENT_ID+"="+id, null);
        StudentModel student = null;
        if (cursor.moveToFirst()) {
            do {
                student = new StudentModel(cursor.getString(1), cursor.getInt(2), cursor.getInt(3) == 0 ? false : true,cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return student;
    }
    void deleteStudent(int id){
        String query = "DELETE FROM "+STUDENT_TABLE+" WHERE "+STUDENT_ID+" = "+id;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        Log.d("Result", "deleteStudent: ");
        db.close();
    }
    void updateStudent(StudentModel student){

        int isActive = student.isActive()?1:0;
        String query = "UPDATE " +STUDENT_TABLE+" SET "+STUDENT_NAME +" = '"
                + student.getName() +"' , "+STUDENT_AGE+" = "+student.getAge()+", "+
                STUDENT_ACTIVE+" = "+isActive + "" +
                " WHERE "+STUDENT_ID +" = "+student.getId();
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
        Log.d("Result", "updateStudent: ");
        db.close();
    }
}