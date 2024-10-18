package com.example.prac3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Student student);
    }

    public StudentAdapter(List<Student> studentList, OnItemClickListener listener) {
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student, listener);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView studentName;
        private TextView studentGPA;

        public StudentViewHolder(View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            studentGPA = itemView.findViewById(R.id.student_gpa);
        }

        public void bind(Student student, OnItemClickListener listener) {
        }

//        public void bind(final Student student, final OnItemClickListener listener) {
//            studentName.setText(student.getFirstName() + " " + student.getLastName());
//            studentGPA.setText("GPA: " + student.getGpa());
//            itemView.setOnClickListener(v -> listener.onItemClick(student));
//        }
    }
}

