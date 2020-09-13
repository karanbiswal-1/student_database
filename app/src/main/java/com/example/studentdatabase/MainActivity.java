package com.example.studentdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRcstudentList;
    private DBhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mRcstudentList = findViewById(R.id.rc_students_data);
        mRcstudentList.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false));

        dbhelper = new DBhelper(MainActivity.this);
        loadDataToDatabase();

    }
    private void loadDataToDatabase(){
        ArrayList<studentDetail> Details = dbhelper.getDataFromDatabase(dbhelper.getWritableDatabase());

        studentDetailsAdapter adapter = new studentDetailsAdapter(MainActivity.this,Details);

        mRcstudentList.setAdapter(adapter);
    }

    public void onEnterClicked(View view){
         Intent newStudentIntent = new Intent(MainActivity.this,submitActivity.class);
         startActivityForResult(newStudentIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                loadDataToDatabase();
            }
        }
    }
}
