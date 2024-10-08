package com.example.prac3;

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

        // Đọc dữ liệu JSON từ file raw
        studentList = getStudentsFromJSON();

        // Gắn adapter cho RecyclerView
        adapter = new StudentAdapter(studentList, student -> {
            // Xử lý khi nhấn vào sinh viên
            Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
            intent.putExtra("student", student);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        // Tạm thời không xử lý sự kiện cho FAB
    }

    // Phương thức đọc JSON từ file raw và chuyển đổi thành danh sách sinh viên
    private List<Student> getStudentsFromJSON() {
        List<Student> students = new ArrayList<>();

        try {
            // Đọc file students.json từ thư mục raw
            InputStream inputStream = getResources().openRawResource(R.raw.students);
            InputStreamReader reader = new InputStreamReader(inputStream);

            // Sử dụng Gson để parse dữ liệu JSON thành danh sách sinh viên
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

