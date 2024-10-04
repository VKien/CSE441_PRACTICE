package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText gpaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        gpaEditText = findViewById(R.id.gpaEditText);
        Button submitButton = findViewById(R.id.bt_submit);

        submitButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            double gpa = Double.parseDouble(gpaEditText.getText().toString());

            Intent returnIntent = new Intent();
            returnIntent.putExtra("name", name);
            returnIntent.putExtra("gpa", gpa);

            setResult(RESULT_OK, returnIntent);
            finish();
        });
    }
}

