package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class submitActivity extends AppCompatActivity {
    private EditText mEtname;
    private EditText mEtcourse;
    private EditText mEtphone;
    private EditText mEtemail;
    private EditText mEtyear;
    private  DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        mEtname = findViewById(R.id.et_name);
        mEtcourse = findViewById(R.id.et_course);
        mEtphone = findViewById(R.id.et_phone);
        mEtemail = findViewById(R.id.et_email);
        mEtyear = findViewById(R.id.et_year);
        dBhelper = new DBhelper(submitActivity.this);
    }
    public void onSubmitClicked(View view){
        String studentName = mEtname.getText().toString();
        String studentCourse = mEtcourse.getText().toString();
        String studentPhone = mEtphone.getText().toString();
        String studentEmail = mEtemail.getText().toString();
        String studentYear = mEtyear.getText().toString();

        studentDetail newStudent = new studentDetail();
        newStudent.studentName = studentName;
        newStudent.studentCourse = studentCourse;
        newStudent.studentPhone = studentPhone;
        newStudent.studentEmail = studentEmail;
        newStudent.studentYear = studentYear;

        mEtname.setText("");
        mEtcourse.setText("");
        mEtphone.setText("");
        mEtemail.setText("");
        mEtyear.setText("");

        dBhelper.insertDataToDatabase(dBhelper.getWritableDatabase(),newStudent);

        Intent returnIntent = new Intent(submitActivity.this,MainActivity.class);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}

