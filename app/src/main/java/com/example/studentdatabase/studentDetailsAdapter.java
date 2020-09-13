package com.example.studentdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class studentDetailsAdapter extends RecyclerView.Adapter<studentDetailsAdapter.studentDetailHolder> {

    private Context context;
    private ArrayList<studentDetail> studentDetails;


    public studentDetailsAdapter(Context context,ArrayList<studentDetail> studentDetails){
        this.context = context;
        this.studentDetails = studentDetails;
    }

    @NonNull
    @Override
    public studentDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cell_student,parent,false);
        studentDetailHolder holder = new studentDetailHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull studentDetailHolder holder, int position) {
        final studentDetail currentStudentDetail = studentDetails.get(position);
        holder.mTvusername.setText(currentStudentDetail.studentName);
        holder.mTvuseremail.setText(currentStudentDetail.studentEmail);
        holder.mTvuserphone.setText(currentStudentDetail.studentPhone);
        holder.mTvuseryear.setText(currentStudentDetail.studentYear);
        holder.mTvusercourse.setText(currentStudentDetail.studentCourse);
    }

    @Override
    public int getItemCount() {
        return studentDetails.size();
    }

    class studentDetailHolder extends RecyclerView.ViewHolder{
     private TextView mTvusername;
     private TextView mTvuseremail;
     private TextView mTvuserphone;
     private TextView mTvuseryear;
     private TextView mTvusercourse;

     public studentDetailHolder(@NonNull View itemView) {
         super(itemView);
         mTvusername = itemView.findViewById(R.id.tv_user_name);
         mTvuseremail = itemView.findViewById(R.id.tv_user_email);
         mTvuserphone = itemView.findViewById(R.id.tv_user_phone);
         mTvuseryear = itemView.findViewById(R.id.tv_user_year);
         mTvusercourse = itemView.findViewById(R.id.tv_user_course);
     }
 }
}
