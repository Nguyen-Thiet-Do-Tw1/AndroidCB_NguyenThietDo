package com.example.th_17_09_2024_bai2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtC, edtF;
    Button btnC, btnF, btnClear;

    private void innitControl(){
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnC = findViewById(R.id.btnC);
        btnF = findViewById(R.id.btnF);
        btnClear = findViewById(R.id.btnClear);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtC.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu độ C", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int C = Integer.parseInt(edtC.getText().toString());
                        Double F = (double)C*1.8 + 32;
                        edtF.setText(String.valueOf(F));

                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtF.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn cần nhập dữ liệu độ F", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int F = Integer.parseInt(edtF.getText().toString().trim());
                        Double C = (F-32)/1.8;
                        edtC.setText(String.valueOf(C));

                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtF.setText("");
                edtC.setText("");
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        innitControl();
    }
}