package com.example.project_cal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
    EditText edt1, edt2, edt3;
    Button btncong, btntru, btnnhan, btnchia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = edt1.findViewById(R.id.edta);
        edt2 = edt2.findViewById(R.id.edtb);
        edt3 = edt3.findViewById(R.id.edtc);
        btncong = btncong.findViewById(R.id.btncong);
        btntru = btntru.findViewById(R.id.btntru);
        btnchia = btnchia.findViewById(R.id.btnchia);
        btnnhan = btnnhan.findViewById(R.id.btnnhan);
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
// TODO Auto-generated method stub
                edt3.setText("a + b =" +(a+b));
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
// TODO Auto-generated method stub
                edt3.setText("a - b =" +(a-b));
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
// TODO Auto-generated method stub
                edt3.setText("a * b =" +(a*b));
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0"+edt2.getText());
                if (b == 0)
                {
                    edt3.setText("B phai khac 0");
                }
else
                {
                    edt3.setText("a / b =" +(a/b));
                }
            }
        });
    }

    public void setContentView(int activityMain) {
    }
}
