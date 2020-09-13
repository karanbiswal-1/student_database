package com.example.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "student_table";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "student_name";
    private static final String COL_COURSES = "student_courses";
    private static final String COL_CONTACT = "student_phone";
    private static final String COL_EMAIL = "student_email";
    private static final String COL_YEAR = "student_year";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " TEXT,"
            + COL_COURSES + " TEXT," + COL_CONTACT + " TEXT," + COL_EMAIL + " TEXT," + COL_YEAR + " TEXT)";

    public DBhelper(@Nullable Context context) {
        super(context, "studentsDetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertDataToDatabase(SQLiteDatabase database, studentDetail studentDetail) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, studentDetail.studentName);
        cv.put(COL_COURSES, studentDetail.studentCourse);
        cv.put(COL_CONTACT, studentDetail.studentPhone);
        cv.put(COL_EMAIL, studentDetail.studentEmail);
        cv.put(COL_YEAR, studentDetail.studentYear);

        database.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<studentDetail> getDataFromDatabase(SQLiteDatabase database) {


        ArrayList<studentDetail> studentDetails = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String course = cursor.getString(cursor.getColumnIndex(COL_COURSES));
                String phone = cursor.getString(cursor.getColumnIndex(COL_CONTACT));
                String email = cursor.getString(cursor.getColumnIndex(COL_EMAIL));
                String year = cursor.getString(cursor.getColumnIndex(COL_YEAR));

                studentDetail stu = new studentDetail();
                stu.studentId = id;
                stu.studentName = name;
                stu.studentCourse = course;
                stu.studentPhone = phone;
                stu.studentEmail = email;
                stu.studentYear = year;

                studentDetails.add(stu);
            }while(cursor.moveToNext());
        }


        return studentDetails;
    }
}
