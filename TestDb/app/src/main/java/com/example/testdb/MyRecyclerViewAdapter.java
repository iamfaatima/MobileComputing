package com.example.testdb;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    List<StudentModel> students;
    public MyRecyclerViewAdapter(List<StudentModel> list){
        students=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent,false);
        return new MyViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.data = students.get(position);
        holder.name.setText(holder.data.getName());
        holder.age.setText(Integer.toString(holder.data.getAge()));
        holder.status.setText(holder.data.isActive() == false ?"false":"true");
        holder.id = holder.data.getId();
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DBHelper(view.getContext()).deleteStudent(holder.id);
                Log.d("Delete", "onClick: Delete");
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),EditDelete.class);
                intent.putExtra("id",holder.id);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,age,status;
        StudentModel data;
        Button delete;
        Button edit;
        int id;
        public MyViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
            age = itemView.findViewById(R.id.studentAge);
            status=itemView.findViewById(R.id.studentStatus);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
        }
    }
}