package com.example.prac3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentList = getStudentsFromJSON();
        adapter = new StudentAdapter(studentList, student -> {
            Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
            intent.putExtra("student", student);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
    }

    private List<Student> getStudentsFromJSON() {
        List<Student> students = new ArrayList<>();

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.students);
            InputStreamReader reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
            students = gson.fromJson(reader, studentListType);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}

