package com.example.prac3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        TextView detailTextView = findViewById(R.id.detailTextView);

        Student student = (Student) getIntent().getSerializableExtra("student");
        if (student != null) {
            detailTextView.setText("ID: " + student.getId() + "\n"
                    + "Name: " + student.getFirstName() + " " + student.getLastName() + "\n"
                    + "GPA: " + student.getGpa());
        }
    }
}

